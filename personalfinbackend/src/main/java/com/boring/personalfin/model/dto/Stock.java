package com.boring.personalfin.model.dto;

public class Stock {
    public String assetName;
    public String ticker;
    public Double average;
    public Double price;

    public Integer quantity;

    public Stock(String assetName, String ticker, Double average, Double price, Integer quantity) {
        this.assetName = assetName;
        this.ticker = ticker;
        this.average = average;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "assetName='" + assetName + '\'' +
                ", ticker='" + ticker + '\'' +
                ", average=" + average +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
