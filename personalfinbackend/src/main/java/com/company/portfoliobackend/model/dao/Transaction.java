package com.company.portfoliobackend.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document

public class Transaction {

    private String id;
    @JsonIgnore
    private String userid;
    private String assetName;
    private String ticker;
    private Double average;
    private Integer quantity;
    private Date transactionDate;


    public Transaction(String assetName, String ticker, Double average, Integer quantity) {
        this.assetName = assetName;
        this.ticker = ticker;
        this.average = average;
        this.quantity = quantity;
    }

    public Transaction() {

    }
}
