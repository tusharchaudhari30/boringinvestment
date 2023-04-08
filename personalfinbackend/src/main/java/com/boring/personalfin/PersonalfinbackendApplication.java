package com.boring.personalfin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PersonalfinbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalfinbackendApplication.class, args);
    }

}
