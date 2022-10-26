package com.boringinvestment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import javax.annotation.processing.Generated;
import java.util.Date;

@MongoEntity(collection = "transaction")
public class Transaction {

    public ObjectId id;
    public String userid;
    public String assetName;
    public String ticker;
    public Integer average;
    public Integer quantity;
    public Date transactionDate;

    public Transaction(String userid, String assetName, String ticker, Integer average, Integer quantity, Date transactionDate) {
        this.userid = userid;
        this.assetName = assetName;
        this.ticker = ticker;
        this.average = average;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }
}
