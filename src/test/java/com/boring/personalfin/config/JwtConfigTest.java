package com.boring.personalfin.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JwtConfigTest {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void passwordEncoder() {
        String password = "password";
        String encryption = passwordEncoder.encode(password);
        assertFalse(passwordEncoder.matches("wrongpassword", encryption));
        assertTrue(passwordEncoder.matches(password, encryption));
    }
}