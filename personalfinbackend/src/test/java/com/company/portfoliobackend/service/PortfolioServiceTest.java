package com.company.portfoliobackend.service;

import com.company.portfoliobackend.model.dao.Transaction;
import com.company.portfoliobackend.model.dao.User;
import com.company.portfoliobackend.model.dto.Portfolio;
import com.company.portfoliobackend.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PortfolioServiceTest {
    @Autowired
    private PortfolioService portfolioService;

    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    void testGetTransactionByToken() {
        // Set up mock objects
        String token = "test-token";
        String email = "test@example.com";
        when(authenticationService.validate(token)).thenReturn(new User(null,email));
        when(transactionRepository.findAllByUseridOrderByTransactionDateDesc(email, PageRequest.of(0, 5)))
                .thenReturn(List.of(new Transaction(), new Transaction()));
        when(transactionRepository.countByUserid(email)).thenReturn(10);

        // Invoke the method under test
        Map<String, Object> result = portfolioService.getTransactionByToken(token, 0);

        // Verify the results
        assertEquals(List.of(new Transaction(), new Transaction()), result.get("transaction"));
        assertEquals(2L, result.get("pages"));
    }
    @Test
    void testGetPortfolio() {
        // Set up mock objects
        String token = "test-token";
        String email = "test@example.com";
        when(authenticationService.validate(token)).thenReturn(new User(null,email));
        when(transactionRepository.findAllByUserid(email)).thenReturn(List.of(
                new Transaction("Stock A", "A", 100.0, 10),
                new Transaction("Stock B", "B", 50.0, 20)
        ));

        // Invoke the method under test
        Portfolio result = portfolioService.getPortfolio(token);

        // Verify the results
        assertEquals(2000, result.invested, 1e-6);
        assertEquals(15000.0, result.holding, 1e-6);
        assertEquals(13000, result.profit, 1e-6);
        assertEquals(650.0, result.percentageReturn, 1e-6);
        assertEquals(2, result.stockList.size());
        assertEquals("Stock A", result.stockList.get(0).assetName);
        assertEquals(500.0, result.stockList.get(0).price, 1e-6);
        assertEquals(10, result.stockList.get(0).quantity);
        assertEquals("Stock B", result.stockList.get(1).assetName);
        assertEquals(500.0, result.stockList.get(1).price, 1e-6);
        assertEquals(20, result.stockList.get(1).quantity);
    }

}