package com.company.portfoliobackend.controller;

import com.company.portfoliobackend.model.dao.Transaction;
import com.company.portfoliobackend.repository.TransactionRepository;
import com.company.portfoliobackend.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class TransactionController {
    final
    PortfolioService portfolioService;

    final
    TransactionRepository transactionRepository;

    public TransactionController(PortfolioService portfolioService, TransactionRepository transactionRepository) {
        this.portfolioService = portfolioService;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/transaction/{page}")
    public Map<String, Object> getTransactionList(@RequestHeader("Authorization") String token, @PathVariable String page) {
        return portfolioService.getTransactionByToken(token, Integer.valueOf(page));
    }

    @PostMapping("/transaction")
    public ResponseEntity<String> saveTransaction(@RequestHeader("Authorization") String token, @RequestBody Transaction transaction) {
        if (transaction.getQuantity() == 0 || transaction.getAverage() == 0) return ResponseEntity.status(405).body("Failed");

        portfolioService.saveTransaction(token, transaction);
        return ResponseEntity.status(200).body("OK");
    }

    @DeleteMapping("/transaction")
    public ResponseEntity<String> deleteTransaction(@RequestParam("id") String id) {
        try {
            transactionRepository.deleteById(id);
            return ResponseEntity.ok("delete");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.toString());
        }
    }

}
