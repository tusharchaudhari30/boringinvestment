package com.boringinvestment.controller;

import com.boringinvestment.service.yahoofinance.YahoofinanceRest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SharePriceController {
    @Inject
    YahoofinanceRest yahoofinanceRest;

    @GET
    @Path("/price")
    public double getStockPrice(@QueryParam("symbol") String symbol) {
        return yahoofinanceRest.getStockPrice(symbol);
    }
}
