package com.company.portfoliobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PortfoliobackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfoliobackendApplication.class, args);
    }

}
