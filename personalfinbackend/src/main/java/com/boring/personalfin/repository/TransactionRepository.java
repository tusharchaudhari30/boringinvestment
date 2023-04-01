package com.boring.personalfin.repository;

import com.boring.personalfin.model.dao.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findAllByUseridOrderByTransactionDateDesc(String userid, Pageable pageable);

    List<Transaction> findAllByUserid(String userid);

    void deleteById(String id);

    Integer countByUserid(String userid);
}
