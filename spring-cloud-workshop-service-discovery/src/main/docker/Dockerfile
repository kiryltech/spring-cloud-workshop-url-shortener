FROM nimmis/alpine-java
ADD spring-cloud-workshop-service-discovery-1.0-SNAPSHOT.jar spring-cloud-workshop-service-discovery.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/root/spring-cloud-workshop-service-discovery.jar"]