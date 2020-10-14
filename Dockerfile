FROM tomcat:9.0.38-jdk14

ENV SPRING_BOOT_WEBBLOG_DB_URL jdbc:mysql://localhost:3306/spring_boot_webblog
ENV SPRING_BOOT_WEBBLOG_DB_USERNAME root
ENV SPRING_BOOT_WEBBLOG_DB_PASSWORD root

COPY target/bbrow_webblog.war /usr/local/tomcat/webapps/bbrow_webblog.war

