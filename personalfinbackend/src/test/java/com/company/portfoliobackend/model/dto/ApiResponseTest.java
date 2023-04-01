package com.company.portfoliobackend.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ApiResponseTest {

    @Test
    public void testApiResponse() {
        // Create an ApiResponse object with success set to true and message set to "Success"
        ApiResponse apiResponse = new ApiResponse(true, "Success");

        // Verify that the success field is set to true
        assertTrue(apiResponse.isSuccess());

        // Verify that the message field is set to "Success"
        assertEquals("Success", apiResponse.getMessage());
    }
}
