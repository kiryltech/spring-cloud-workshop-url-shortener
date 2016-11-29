FROM nimmis/alpine-java
ADD spring-cloud-workshop-config-server-1.0-SNAPSHOT.jar spring-cloud-workshop-config-server.jar
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/root/spring-cloud-workshop-config-server.jar"]