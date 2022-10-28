package com.boringinvestment.controller;

import com.boringinvestment.model.User;
import com.boringinvestment.security.TokenService;
import org.jboss.logmanager.Logger;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    public final static Logger LOGGER = Logger.getLogger(TokenService.class.getSimpleName());
    @Inject
    TokenService tokenService;

    @POST
    @Path("/register")
    public void register(User user) {
        System.out.println(user);
        user.persist();
    }

    @GET
    @Path("/login")
    public String login(@QueryParam("login")String login, @QueryParam("password") String password) {
        User existingUser = User.find("login", login).firstResult();
        if(existingUser == null || !existingUser.password.equals(password)) {
            LOGGER.warning("User not found:"+login);
            throw new WebApplicationException(Response.status(404).entity("No user found or password is incorrect").build());
        }
        return tokenService.generateUserToken(existingUser.email);
    }
}
