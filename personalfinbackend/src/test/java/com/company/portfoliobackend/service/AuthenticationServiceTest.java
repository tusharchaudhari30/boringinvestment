package com.company.portfoliobackend.service;

import com.company.portfoliobackend.exception.TokenValidationFailedException;
import com.company.portfoliobackend.feign.AuthenticationFeignClient;
import com.company.portfoliobackend.model.dao.User;
import com.company.portfoliobackend.model.dto.AuthenticationResponse;
import com.company.portfoliobackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthenticationServiceTest {

    @Mock
    private AuthenticationFeignClient authFeign;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthenticationService authenticationService;



    @Test
    void validate() {
        // Set up mock behavior for authFeign
        when(authFeign.validateToken("valid_token"))
                .thenReturn(new AuthenticationResponse("user@example.com", true, "Success", "valid_token"));
        // Set up mock behavior for userRepository
        User user = new User(null,"user@example.com");
        when(userRepository.findUserByEmail("user@example.com")).thenReturn(user);

        // Test valid token
        User result = authenticationService.validate("valid_token");
        assertEquals(user, result);
    }
    @Test
    public void validate_InvalidToken_ThrowsException() {
        // Set up mock behavior for authFeign
        when(authFeign.validateToken("invalid_token"))
                .thenThrow(new TokenValidationFailedException("Invalid token"));

        // Test invalid token
        try {
            authenticationService.validate("invalid_token");
            fail("Expected TokenValidationFailedException");
        } catch (TokenValidationFailedException e) {
            assertEquals("Invalid token", e.getMessage());
        }
    }
}