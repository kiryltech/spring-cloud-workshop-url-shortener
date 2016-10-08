package org.kduborenko;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kiryl Dubarenka
 */
@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home(@Value("${greeting.name}") String name) {
        return String.format("Hello %s!", name);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
