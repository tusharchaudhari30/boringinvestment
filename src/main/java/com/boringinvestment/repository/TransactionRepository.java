package com.boringinvestment.repository;

import com.boringinvestment.model.Transaction;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TransactionRepository implements PanacheMongoRepository<Transaction> {
    public Map<String, Object> findTransactionsByUserid(String userId, Integer page) {
        PanacheQuery<Transaction> transactionPanacheQuery = find("userid", userId);
        Map<String, Object> map = new HashMap<>();
        long transactionCount = transactionPanacheQuery.count();
        long count = transactionCount / 5;
        if (transactionPanacheQuery.count() % 5 != 0) count += 1;
        map.put("pages", count);
        map.put("transaction", transactionPanacheQuery.page(Page.of(page, 5)).list());
        return map;
    }

    public List<Transaction> findTransactionsByUserid(String userid) {
        return list("userid", userid);
    }
}
