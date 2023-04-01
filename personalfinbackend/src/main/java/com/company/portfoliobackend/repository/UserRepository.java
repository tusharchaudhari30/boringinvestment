package com.company.portfoliobackend.repository;

import com.company.portfoliobackend.model.dao.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByEmail(String email);
}
