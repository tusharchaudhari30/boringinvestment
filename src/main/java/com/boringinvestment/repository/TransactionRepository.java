package com.boringinvestment.repository;

import com.boringinvestment.model.Transaction;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TransactionRepository implements PanacheMongoRepository<Transaction> {
    public List<Transaction> findTransactionsByUserid(String userId,Integer page){
        PanacheQuery<Transaction> transactionPanacheQuery = find("userid",userId);
        return transactionPanacheQuery.page(Page.of(page,5)).list();
    }
    public List<Transaction> findTransactionsByUserid(String userid){
        return list("userid",userid);
    }
}
