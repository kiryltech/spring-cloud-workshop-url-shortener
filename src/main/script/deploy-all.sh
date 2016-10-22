#!/usr/bin/env bash

config_repo=${1:-https://github.com/kduborenko/spring-cloud-workshop-url-shortener-config.git}

echo "Starting Redis"

docker run -d \
        -h spring-cloud-workshop-redis \
        --name spring-cloud-workshop-redis \
        redis

echo "Starting Service Discovery Server"

docker run -d \
        -h spring-cloud-workshop-service-discovery \
        --name spring-cloud-workshop-service-discovery url-shortener/spring-cloud-workshop-service-discovery

echo "Starting Configuration Server"

docker run -d \
        -h spring-cloud-workshop-config-server \
        --name spring-cloud-workshop-config-server \
        url-shortener/spring-cloud-workshop-config-server --spring.cloud.config.server.git.uri=$config_repo

echo -n "Waiting for Configuration Server"

until $(curl --output /dev/null --connect-timeout 1 --silent --head --fail http://172.17.0.4:8888/info); do
    printf '.'
    sleep 1
done
echo

echo "Starting URL Shortener Backend Server"

docker run -d \
        --link=spring-cloud-workshop-config-server \
        --link=spring-cloud-workshop-redis \
        --link=spring-cloud-workshop-service-discovery \
        -h spring-cloud-workshop-url-shortener-backend \
        --name spring-cloud-workshop-url-shortener-backend \
        url-shortener/spring-cloud-workshop-url-shortener-backend --spring.cloud.config.uri=http://spring-cloud-workshop-config-server:8888/

echo "Starting URL Shortener Frontend Server"

docker run -d \
        --link=spring-cloud-workshop-config-server \
        --link=spring-cloud-workshop-service-discovery \
        -h spring-cloud-workshop-url-shortener-frontend \
        --name spring-cloud-workshop-url-shortener-frontend \
        -p 8080:8080 \
        url-shortener/spring-cloud-workshop-url-shortener-frontend --spring.cloud.config.uri=http://spring-cloud-workshop-config-server:8888/
