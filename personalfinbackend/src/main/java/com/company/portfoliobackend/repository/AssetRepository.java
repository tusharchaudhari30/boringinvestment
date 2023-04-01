package com.company.portfoliobackend.repository;

import com.company.portfoliobackend.model.dao.Assets;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssetRepository extends MongoRepository<Assets, String> {
    List<Assets> findByAssetNameContainingIgnoreCase(String query);
}
