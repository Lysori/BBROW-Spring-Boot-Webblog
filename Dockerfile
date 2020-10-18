FROM tomcat:9.0.38-jdk14

COPY target/bbrow-blog.war /usr/local/tomcat/webapps/bbrow-blog.war
CMD ["catalina.sh","run"]

