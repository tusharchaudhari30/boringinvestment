package com.boringinvestment.controller;

import com.boringinvestment.model.Transaction;
import com.boringinvestment.repository.TransactionRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionController {

    @Inject
    TransactionRepository transactionRepository;

    @GET
    @Path("/findbyuserid/{userid}")
    public List<Transaction> findbyUserid(@PathParam("userid") String userid){
        return transactionRepository.findTransactionsByUserid(userid);
    }

    @POST
    public void saveTransaction(Transaction transaction){
        transactionRepository.persist(transaction);
    }

    @PUT
    public void updateTransaction(Transaction transaction){
        transactionRepository.update(transaction);
    }
}
