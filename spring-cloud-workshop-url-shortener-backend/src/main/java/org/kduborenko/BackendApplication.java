package org.kduborenko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

import javax.servlet.Filter;

/**
 * @author Kiryl Dubarenka
 */
@SpringBootApplication
@EnableEurekaClient
public class BackendApplication {

    @Bean
    public Filter logFilter() {
        ServletContextRequestLoggingFilter filter = new ServletContextRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setIncludeClientInfo(true);
        filter.setMaxPayloadLength(5120);
        return filter;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
