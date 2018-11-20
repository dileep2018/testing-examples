node('javaslave') {	
 stage('SCM Checkout'){
         git 'https:https://github.com/dileep2018/testing-examples'
   }
   stage('validate'){
       // Get maven home path
       def mvnHome = tool name: 'maven-3', type: 'maven'
       sh "${mvnHome}/bin/mvn clean compile"
   }
   stage('SonarQube Analysis') {
        def mvnHome =  tool name: 'maven-3', type: 'maven'
        withSonarQubeEnv('sonarqube_java') { 
          sh "${mvnHome}/bin/mvn sonar:sonar"
        }
    }
    stage("Quality Gate"){
       timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
         def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
	 if (qg.status != 'OK') {
	   error "Pipeline aborted due to quality gate failure: ${qg.status}"
         }   
       }
     }		 
}
