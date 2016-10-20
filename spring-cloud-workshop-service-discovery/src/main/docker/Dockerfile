FROM java:8
ADD spring-cloud-workshop-service-discovery-1.0-SNAPSHOT.jar spring-cloud-workshop-service-discovery.jar
VOLUME /tmp
VOLUME /target
RUN bash -c 'touch /spring-cloud-workshop-service-discovery.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-cloud-workshop-service-discovery.jar"]