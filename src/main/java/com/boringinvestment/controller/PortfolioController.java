package com.boringinvestment.controller;

import com.boringinvestment.model.Portfolio;
import com.boringinvestment.security.Roles;
import com.boringinvestment.service.portfolioservice.PortfolioService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/portfolio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({Roles.USER})
public class PortfolioController {

    @Context
    SecurityContext securityContext;

    @Inject
    PortfolioService portfolioService;

    @GET
    public Portfolio getPortfolio() {
        return portfolioService.getPortfolio(securityContext.getUserPrincipal().getName());
    }
}
