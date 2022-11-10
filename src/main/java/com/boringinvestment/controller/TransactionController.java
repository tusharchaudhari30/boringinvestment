package com.boringinvestment.controller;

import com.boringinvestment.model.Transaction;
import com.boringinvestment.repository.TransactionRepository;
import com.boringinvestment.security.Roles;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({Roles.USER})
public class TransactionController {

    @Inject
    TransactionRepository transactionRepository;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("/{page}")
    @RolesAllowed({Roles.USER})
    public List<Transaction> findTransactionUserid(@PathParam("page")Integer page){
        return transactionRepository.findTransactionsByUserid(securityContext.getUserPrincipal().getName(),page);
    }

    @POST
    @RolesAllowed({Roles.USER})
    public String saveTransaction(Transaction transaction){
        transaction.id=null;
        transaction.userid=securityContext.getUserPrincipal().getName();
        transactionRepository.persist(transaction);
        return "Saved";
    }

    @PUT
    @RolesAllowed({Roles.USER})
    public void updateTransaction(Transaction transaction){
        transactionRepository.update(transaction);
    }
}
