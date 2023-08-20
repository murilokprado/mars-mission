package com.marsmission;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenAPI", version = "1", description = "API Mars Mission APP"))
@ComponentScan("com.marsmission")
public class MarsMissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsMissionApplication.class, args);
    }

}
