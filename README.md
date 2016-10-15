# Overview

_TDB_

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

    _TDB_
    
# Run application

## Deployment overview

![Deployment diagram](https://docs.google.com/drawings/d/1xilPK_p60sVNcpOod4x9wjNWi4RzWcxvPWkFsOsYYz8/export/png)

## Deployment of local instances

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
        $ touch application.yml
        ```
       
        With content
       
        ```yaml
        redis:
          connection:
            host: 172.17.0.2 # Replace by address of your Redis instance
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
    $ java -jar spring-cloud-workshop-url-shortener-frontend/target/spring-cloud-workshop-url-shortener-frontend-1.0-SNAPSHOT.jar 
    ```
