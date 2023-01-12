package com.lolineet.standard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class LolineetApplication {

    public static void main(String[] args) {
        SpringApplication.run(LolineetApplication.class, args);
    }

}
