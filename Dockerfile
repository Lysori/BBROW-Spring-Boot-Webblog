FROM tomcat:latest

COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY context.xml /usr/local/tomcat/webapps.dist/manager/META-INF/context.xml
RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webappsBackup
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps

ARG USER
ARG PASSWORD
ENV SPRING_BOOT_WEBBLOG_DB_USERNAME=${USER}
ENV SPRING_BOOT_WEBBLOG_DB_PASSWORD=${PASSWORD}
COPY target/bbrow-blog.war /usr/local/tomcat/webapps/bbrow-blog.war

CMD ["catalina.sh","run"]

