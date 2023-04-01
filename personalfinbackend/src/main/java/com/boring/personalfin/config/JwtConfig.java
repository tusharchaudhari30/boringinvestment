package com.boring.personalfin.config;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String SECRETKEY;

    @Bean
    public Algorithm algorithm(){
        return Algorithm.HMAC256(SECRETKEY);
    }
}
