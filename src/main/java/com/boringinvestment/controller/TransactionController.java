package com.boringinvestment.controller;

import com.boringinvestment.model.Transaction;
import com.boringinvestment.repository.TransactionRepository;
import com.boringinvestment.security.Roles;
import org.bson.types.ObjectId;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;
import java.util.Map;

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
    public Map<String,Object> findTransactionUserid(@PathParam("page") Integer page) {
        if (page < 0) page = 0;
        return transactionRepository.findTransactionsByUserid(securityContext.getUserPrincipal().getName(), page);
    }

    @POST
    @RolesAllowed({Roles.USER})
    public Response saveTransaction(Transaction transaction) {
        if (transaction.quantity == 0 || transaction.average == 0) return Response.status(405).build();
        transaction.id = null;
        transaction.userid = securityContext.getUserPrincipal().getName();
        transactionRepository.persist(transaction);
        return Response.ok().status(200).build();
    }

    @PUT
    @RolesAllowed({Roles.USER})
    public void updateTransaction(Transaction transaction) {
        transactionRepository.update(transaction);
    }

    @DELETE
    @RolesAllowed({Roles.USER})
    public Response deleteTransaction(@QueryParam("id") String transaction) {
        transactionRepository.deleteById(new ObjectId(transaction));
        return Response.ok().build();
    }
}
