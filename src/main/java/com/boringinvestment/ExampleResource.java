package com.boringinvestment;

import com.boringinvestment.model.User;
import com.boringinvestment.security.Roles;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/hello")
public class ExampleResource {

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/me")
    @RolesAllowed({Roles.USER, Roles.SERVICE})
    public User me() {
        return User.find("email", securityContext.getUserPrincipal().getName()).firstResult();
    }

    @GET
    @Path("/admin")
    @RolesAllowed(Roles.ADMIN)
    public String adminTest() {
        return "If you see this text as a user, then something is broke";
    }

    @GET
    @Path("/void")
    @DenyAll
    public String nothing() {
        return "This method should always return 403";
    }

}