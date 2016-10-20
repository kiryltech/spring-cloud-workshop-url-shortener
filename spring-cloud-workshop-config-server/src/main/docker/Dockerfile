FROM java:8
ADD spring-cloud-workshop-config-server-1.0-SNAPSHOT.jar spring-cloud-workshop-config-server.jar
VOLUME /tmp
VOLUME /target
RUN bash -c 'touch /spring-cloud-workshop-config-server.jar'
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-cloud-workshop-config-server.jar"]