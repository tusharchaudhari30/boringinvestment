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
    @JsonIgnore
    public String userid;
    public String assetName;
    public String ticker;
    public Double average;
    public Integer quantity;
    public Date transactionDate;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", assetName='" + assetName + '\'' +
                ", ticker='" + ticker + '\'' +
                ", average=" + average +
                ", quantity=" + quantity +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public Transaction(String userid, String assetName, String ticker, Double average, Integer quantity, Date transactionDate) {
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
