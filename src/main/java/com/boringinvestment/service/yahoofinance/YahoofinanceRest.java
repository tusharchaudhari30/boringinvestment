package com.boringinvestment.service.yahoofinance;

import com.boringinvestment.service.yahoofinance.client.ClientRestYahoo;
import com.boringinvestment.service.yahoofinance.model.Result;
import com.boringinvestment.service.yahoofinance.model.SharePriceRequest;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class YahoofinanceRest {
    @RestClient
    @Inject
    ClientRestYahoo clientRestYahoo;

    @Transactional
    public Double getStockPrice(String symbol){
        SharePriceRequest sharePriceRequest=clientRestYahoo.getSharePrice(symbol,"1m","1m");
        return sharePriceRequest.chart.result.get(0).meta.regularMarketPrice;
    }
}
