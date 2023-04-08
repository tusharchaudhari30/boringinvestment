package com.boring.personalfin.controller;


import com.boring.personalfin.model.dao.Transaction;
import com.boring.personalfin.model.dto.ToastMessage;
import com.boring.personalfin.repository.TransactionRepository;
import com.boring.personalfin.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin()
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
    public ResponseEntity<ToastMessage> saveTransaction(@RequestHeader("Authorization") String token, @RequestBody Transaction transaction) {
        if (transaction.getQuantity() == 0 || transaction.getAverage() == 0)
            return ResponseEntity.status(405).body(new ToastMessage("Failed"));

        portfolioService.saveTransaction(token, transaction);
        return ResponseEntity.status(200).body(new ToastMessage("OK"));
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
