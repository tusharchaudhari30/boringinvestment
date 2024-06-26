package com.boring.personalfin.service;


import com.boring.personalfin.model.dao.Transaction;
import com.boring.personalfin.model.dto.Portfolio;
import com.boring.personalfin.model.dto.Stock;
import com.boring.personalfin.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class PortfolioService {
    final
    TransactionRepository transactionRepository;

    final
    AuthenticationService authenticationService;

    public PortfolioService(AuthenticationService authenticationService, TransactionRepository transactionRepository) {
        this.authenticationService = authenticationService;
        this.transactionRepository = transactionRepository;
    }


    // Retrieves paginated transactions for a user identified by a token
    // Returns a map with the transactions and number of pages
    public Map<String, Object> getTransactionByToken(String token, Integer page) {
        // create the map to be returned
        Map<String, Object> map = new HashMap<>();
        // validate the token and get the user's email address
        String userid = authenticationService.validate(token).getEmail();
        log.info("Retrieving transactions for user {} with page {}", userid, page);
        // retrieve the paginated list of transactions for the user
        map.put("transaction", transactionRepository.findAllByUseridOrderByTransactionDateDesc(userid, PageRequest.of(page, 5)));
        // calculate the number of pages
        Integer transactionCount = transactionRepository.countByUserid(userid);
        long count = transactionCount / 5;
        if (transactionCount % 5 != 0) count += 1;
        map.put("pages", Optional.of(count));
        return map;
    }


    // Saves a transaction for a user identified by a token
    public void saveTransaction(String token, Transaction transaction) {
        // validate the token and get the user's email address
        String userid = authenticationService.validate(token).getEmail();
        log.info("Saving transaction for user {} with ticker {} and quantity {}", userid, transaction.getTicker(), transaction.getQuantity());
        // set the id and userid fields of the transaction and save it
        transaction.setId(null);
        transaction.setUserid(userid);
        transactionRepository.save(transaction);
        log.info("Saved transaction for user {} with ticker {} and quantity {}", userid, transaction.getTicker(), transaction.getQuantity());
    }


    // Retrieves the portfolio for a user identified by a token
    public Portfolio getPortfolio(String token) {
        // validate the token and get the user's email address
        String name = authenticationService.validate(token).getEmail();
        log.info("Retrieving portfolio for user {}", name);
        // retrieve the transactions for the user
        List<Transaction> transactionList = transactionRepository.findAllByUserid(name);
        // create a new Portfolio object and a HashMap of Stock objects
        Portfolio portfolio = new Portfolio();
        HashMap<String, Stock> quantityMap = new HashMap<>();
        // populate the Portfolio and HashMap with the transactions data
        if (!transactionList.isEmpty()) {
            transactionList.forEach(transaction -> {
                if (quantityMap.containsKey(transaction.getTicker())) {
                    Stock stock = quantityMap.get(transaction.getTicker());
                    stock.quantity = (Integer) (quantityMap.get(transaction.getTicker()).quantity + transaction.getQuantity());
                    stock.average = (Double) ((stock.average + (transaction.getAverage() * transaction.getQuantity())) / (transaction.getQuantity() + 1));
                    quantityMap.put(transaction.getTicker(), stock);
                } else {
                    quantityMap.put(transaction.getTicker(), new Stock(transaction.getAssetName(), transaction.getTicker(), transaction.getAverage(), Double.valueOf(500.00), transaction.getQuantity()));
                }
            });
            portfolio.transactionList = transactionList;
            quantityMap.forEach((s, stock) -> portfolio.addStock(stock));
            // calculate the profit and percentage return for the portfolio
            portfolio.profit = (Double) (portfolio.holding - portfolio.invested);
            portfolio.percentageReturn = (Double) (portfolio.profit / portfolio.invested * 100);
        } else {
            portfolio.profit = (Double) 0.0;
            portfolio.percentageReturn = (Double) 0.0;
        }
        log.info("Retrieved portfolio for user {} with profit {} and percentage return {}", name, portfolio.profit, portfolio.percentageReturn);
        return portfolio;
    }
}
