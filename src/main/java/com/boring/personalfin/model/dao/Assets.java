package com.boring.personalfin.model.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Assets {
    private String id;
    private String symbol;
    private String assetName;
    private Date dateOfListing;
    private String isin;

    public Assets(String symbol, String assetName, Date dateOfListing, String isin) {
        this.symbol = symbol;
        this.assetName = assetName;
        this.dateOfListing = dateOfListing;
        this.isin = isin;
    }

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
