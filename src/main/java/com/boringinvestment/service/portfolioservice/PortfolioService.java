package com.boringinvestment.service.portfolioservice;


import com.boringinvestment.model.Portfolio;
import com.boringinvestment.model.Stock;
import com.boringinvestment.model.Transaction;
import com.boringinvestment.repository.TransactionRepository;
import com.boringinvestment.service.yahoofinance.YahoofinanceRest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class PortfolioService {

    @Inject
    TransactionRepository transactionRepository;

    @Inject
    YahoofinanceRest yahoofinanceRest;

    public Portfolio getPortfolio(String name){
        List<Transaction> transactionList=transactionRepository.findTransactionsByUserid(name);
        Portfolio portfolio=new Portfolio();
        HashMap<String,Stock> quantityMap=new HashMap<>();
        if(transactionList.size()!=0){
            transactionList.forEach(transaction -> {
                if (quantityMap.containsKey(transaction.ticker)){
                    Stock stock=quantityMap.get(transaction.ticker);
                    stock.quantity=quantityMap.get(transaction.ticker).quantity+transaction.quantity;
                    stock.average= (stock.average+(transaction.average*transaction.quantity))/(transaction.quantity+1);
                    quantityMap.put(transaction.ticker,stock);

                }else {
                    quantityMap.put(transaction.ticker,new Stock(transaction.assetName,transaction.ticker,transaction.average,yahoofinanceRest.getStockPrice(transaction.ticker),transaction.quantity));
                }
            });
            portfolio.transactionList=transactionList;
            quantityMap.forEach((s, stock) -> portfolio.addStock(stock));
            portfolio.profit=portfolio.holding- portfolio.invested;
            portfolio.percentageReturn= portfolio.profit / portfolio.invested * 100;
        }else {
            portfolio.profit=0.0;
            portfolio.percentageReturn=0.0;
        }
        return  portfolio;
    }
}
