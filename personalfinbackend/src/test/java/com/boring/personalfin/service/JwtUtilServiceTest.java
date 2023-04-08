package com.boring.personalfin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JwtUtilServiceTest {
    @Autowired
    JwtUtilService jwtUtilService;

    @Test
    void testToken() {
        String subject = "user@valid.com";
        String token = jwtUtilService.generateToken(subject);
        assertEquals(subject, jwtUtilService.getSubjectFromToken(token));
    }
}