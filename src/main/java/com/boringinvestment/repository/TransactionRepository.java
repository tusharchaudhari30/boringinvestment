package com.boringinvestment.repository;

import com.boringinvestment.model.Transaction;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TransactionRepository implements PanacheMongoRepository<Transaction> {
    public List<Transaction> findTransactionsByUserid(String userId){
        return list("userid",userId);
    }
}
