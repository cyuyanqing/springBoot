package test;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class  HelloController {
    @RequestMapping("hello")
    String hello() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }

}
