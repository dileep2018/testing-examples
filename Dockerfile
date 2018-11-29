# Pull base image
From davidcaste/alpine-tomcat 

# Maintainer
#MAINTAINER " ">

# Copy to images tomcat path
ADD contact.war /usr/local/tomcat/webapps/
