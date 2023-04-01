package com.company.portfoliobackend.repository;

import com.company.portfoliobackend.model.dao.Assets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssetRepositoryTest {
    @Autowired
    private AssetRepository assetRepository;

    @Test
    public void testFindByAssetNameContainingIgnoreCase() {
        // Insert some test assets into the database
        Assets asset1 = new Assets( "STK","Stock 1", new Date(), "123456");
        Assets asset2 = new Assets( "STK","Stock 2", new Date(), "789012");
        Assets asset3 = new Assets( "BND", "Bond 1",new Date(), "345678");
        assetRepository.save(asset1);
        assetRepository.save(asset2);
        assetRepository.save(asset3);

        // Search for assets with "stock" in their name (ignoring case)
        List<Assets> assets = assetRepository.findByAssetNameContainingIgnoreCase("stock");
        System.out.println(assets);
        // Verify that the correct assets are returned
        assertEquals(2, assets.size());
        assertTrue(assets.contains(asset1));
        assertTrue(assets.contains(asset2));
        assetRepository.deleteAll(assets);
    }
}