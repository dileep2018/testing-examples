pipeline {
  agent any
  stages {
    stage('validate') {
      parallel {
        stage('validate') {
          steps {
            sh ' sh "${mvnHome}/bin/mvn clean test"'
          }
        }
        stage('SonarQube Analysis') {
          steps {
            sh 'sh "${mvnHome}/bin/mvn sonar:sonar"'
          }
        }
      }
    }
  }
  environment {
    name = 'javatest'
  }
}