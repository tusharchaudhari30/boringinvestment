package com.boringinvestment.model;

import io.smallrye.common.constraint.NotNull;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    public Double invested;

    public Double holding;

    public List<Stock> stockList;

    public List<Transaction> transactionList;

    public Portfolio() {
        this.invested= (double) 0;
        this.holding= (double) 0;
        stockList=new ArrayList<>();
        transactionList=new ArrayList<>();
    }
    public void addStock(@NotNull Stock stock){
        invested=invested+(stock.average*stock.quantity);
        holding=holding+(stock.price*stock.quantity);
        stockList.add(stock);
    }

}
