FROM nimmis/alpine-java
ADD spring-cloud-workshop-url-shortener-frontend-1.0-SNAPSHOT.jar spring-cloud-workshop-url-shortener-frontend.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/root/spring-cloud-workshop-url-shortener-frontend.jar"]