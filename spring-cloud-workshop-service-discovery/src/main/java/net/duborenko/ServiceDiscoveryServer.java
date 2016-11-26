package net.duborenko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Kiryl Dubarenka
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryServer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryServer.class, args);
    }

}
