FROM java:8
ADD spring-cloud-workshop-url-shortener-backend-1.0-SNAPSHOT.jar spring-cloud-workshop-url-shortener-backend.jar
VOLUME /tmp
VOLUME /target
RUN bash -c 'touch /spring-cloud-workshop-url-shortener-backend.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-cloud-workshop-url-shortener-backend.jar"]