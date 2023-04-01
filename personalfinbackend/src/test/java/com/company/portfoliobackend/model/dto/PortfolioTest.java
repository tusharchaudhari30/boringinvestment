package com.company.portfoliobackend.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {
    @Test
    public void testAddStock() {
        // Create a new Portfolio object
        Portfolio portfolio = new Portfolio();

        // Create some Stock objects
        Stock stock1 = new Stock("Apple", "AAPL", 100.0, 120.0, 10);
        Stock stock2 = new Stock("Microsoft", "MSFT", 80.0, 90.0, 20);

        // Add the Stock objects to the Portfolio
        portfolio.addStock(stock1);
        portfolio.addStock(stock2);

        // Verify that the invested, holding, and stockList fields are correct
        assertEquals(2600.0, portfolio.invested, 0.001);
        assertEquals(3000.0, portfolio.holding, 0.001);
        assertEquals(2, portfolio.stockList.size());
        assertEquals(stock1, portfolio.stockList.get(0));
        assertEquals(stock2, portfolio.stockList.get(1));
    }
}