package com.boringinvestment.service.yahoofinance.client;

import com.boringinvestment.service.yahoofinance.model.SharePriceRequest;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@RegisterRestClient()
public interface ClientRestYahoo {
    @GET
    @Path("/v8/finance/chart/{symbol}")
    SharePriceRequest getSharePrice(@PathParam("symbol") String symbol, @QueryParam("interval") String interval, @QueryParam("range") String range);
}
