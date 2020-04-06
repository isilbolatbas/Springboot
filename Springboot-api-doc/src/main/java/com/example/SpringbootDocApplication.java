package com.example;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@Api(value = "Benim Pet API Dokumantasyonum")
public class SpringbootDocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDocApplication.class, args);
    }
}
