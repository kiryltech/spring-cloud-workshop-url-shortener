# Overview

This is a very simple implementation of URL Shortener service created for educational purposes. It demonstrates microservices architecture based on [Spring Cloud Framework](http://cloud.spring.io/).

# Requirements

* JDK 1.8 or higher
* Maven 3.0 or higher
* Redis 3.0 or higher
* Docker 1.12 or higher

# Build and Install

* Download and unpack
    ![Download zip archive](http://www.clipular.com/c/6151574154117120.png?k=1qXK33dSbTQlaELVhZ3q28rJJVk)
    
    or clone repository:
    
    ```sh
    $ git clone https://github.com/kduborenko/spring-cloud-workshop-url-shortener.git
    ```
* Build application
    From project's root directory run:
    
    ```sh
    $ mvn clean install
    ```
    
    Result should look like:
    
    ```
    [INFO] Reactor Summary:
    [INFO]
    [INFO] Spring Cloud Workshop .............................. SUCCESS [  0.232 s]
    [INFO] Spring Cloud Workshop :: Configuration Server ...... SUCCESS [  1.630 s]
    [INFO] Spring Cloud Workshop :: Service Discovery Server .. SUCCESS [  0.681 s]
    [INFO] Spring Cloud Workshop :: URL Shortener API ......... SUCCESS [  0.087 s]
    [INFO] Spring Cloud Workshop :: URL Shortener Backend ..... SUCCESS [  0.845 s]
    [INFO] Spring Cloud Workshop :: URL Shortener Frontend .... SUCCESS [  0.507 s]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    ```
    
* (Optional) Build Docker images

    Builds automatically on Maven's install stage.
    
# Run application

## Deployment overview

![Deployment diagram](https://docs.google.com/drawings/d/1xilPK_p60sVNcpOod4x9wjNWi4RzWcxvPWkFsOsYYz8/export/png)

## Deployment of local instances

* Setup Redis DB.

    * You can download and install Redis locally as described in official documentation: https://redis.io/topics/quickstart

    * Or you can use following command to run Redis in a Docker container:

        ```sh
        $ docker run -p 6379:6379 redis
        ```

* Create configuration repository:
    
    * Create directory:
        
        ```sh
        $ cd ~ && mkdir config-repo
        ```
        
    * Initialize git repository:
    
        ```sh
        $ cd config-repo && git init
        ```
        
    * Create default application config:
    
        ```sh
        $ touch application.yml
        ```
        
        With content
        
        ```yaml
        eureka:
         client:
           serviceUrl:
             defaultZone: http://localhost:8761/eureka/
        ```
       
    * Create Backend specific configuration file:
    
        ```sh
        $ touch url-shortener-backend.yml
        ```
       
        With content
       
        ```yaml
        redis:
          connection:
            host: localhost
        ```

* Run Configuration Server:
    
    ```sh
    $ java -jar spring-cloud-workshop-config-server/target/spring-cloud-workshop-config-server-1.0-SNAPSHOT.jar \
        --spring.cloud.config.server.git.uri=file://$HOME/config-repo
    ```

* Run Service Discovery Server:

    ```sh
    $ java -jar spring-cloud-workshop-service-discovery/target/spring-cloud-workshop-service-discovery-1.0-SNAPSHOT.jar 
    ```

* Run URL Shortener Backend:

    ```sh
    $ java -jar spring-cloud-workshop-url-shortener-backend/target/spring-cloud-workshop-url-shortener-backend-1.0-SNAPSHOT.jar 
    ```

* Run URL Shortener Frontend:

    ```sh
    $ java -jar spring-cloud-workshop-url-shortener-frontend/target/spring-cloud-workshop-url-shortener-frontend-1.0-SNAPSHOT.jar --server.port=9090
    ```
    Frontend server will be available by following url: [http://localhost:9090/create](http://localhost:9090/create)

## Deployment of local instances with docker

Run deploy-all.sh script:

```sh
$ ./src/main/script/deploy-all.sh [url to config repository]
```
    
Output will look like:
    
```
Starting Redis
4bb7f3e9127561157b3a513e8c3ccc63ab025406318f217bc09cd768be859a27
Starting Service Discovery Server
863dab148fd3786ab341badb7a255d35eaccb312b3cd582ce0e88ace67a9ea27
Starting Configuration Server
a342660ead5d2064d8c771979042af3f1a699b2882af64125f190bada75de625
Waiting for Configuration Server...........
Starting URL Shortener Backend Server
71621b2a4eab5748ce1bd6f7ce0f7437c7acfdef62edb207e0a897a6baa28016
Starting URL Shortener Frontend Server
67cfe0edeac48d70c5e557e77314c07f3927b9c4e5c8155ec7d213437a04cc76
```
    
Frontend server will be available by following url: [http://localhost:8080/create](http://localhost:8080/create)    
    
