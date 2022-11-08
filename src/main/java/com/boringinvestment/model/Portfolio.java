package com.boringinvestment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.smallrye.common.constraint.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    public Double invested;

    public Double holding;

    public Double profit;

    public Double percentageReturn;
    public List<Stock> stockList;
    @JsonIgnore
    public List<Transaction> transactionList;

    public List<ChartModel> chartModels;

    public Portfolio() {
        this.invested= (double) 0;
        this.holding= (double) 0;
        stockList=new ArrayList<>();
        chartModels=new ArrayList<>();
        transactionList=new ArrayList<>();
    }
    public void addStock(@NotNull Stock stock){
        invested=invested+(stock.average*stock.quantity);
        holding=holding+(stock.price*stock.quantity);
        stockList.add(stock);
        chartModels.add(new ChartModel(stock.assetName,stock.price*stock.quantity));
    }

}
