package com.boringinvestment.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.Date;

@MongoEntity(collection = "assets")
public class Asset extends PanacheMongoEntity {
    public String symbol;
    public String assetName;
    public Date dateOfListing;
    public String isin;

    @Override
    public String toString() {
        return "Asset{" +
                "symbol='" + symbol + '\'' +
                ", assetName='" + assetName + '\'' +
                ", dateOfListing=" + dateOfListing +
                ", isin='" + isin + '\'' +
                '}';
    }
}
