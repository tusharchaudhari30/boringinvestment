package com.boringinvestment.controller;

import com.boringinvestment.exception.Declaration.CustomExceptionWithMessage;
import com.boringinvestment.model.User;
import com.boringinvestment.security.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    public final static Logger log= LoggerFactory.getLogger(UserController.class.getSimpleName());
    @Inject
    TokenService tokenService;

    @POST
    @Path("/signup")
    @Produces(MediaType.TEXT_PLAIN)
    public String register(User user) {
        User user1=User.find("email",user.email).firstResult();
        if(user1!=null){
            log.error("User already exist [{}]",user.email);
            throw new CustomExceptionWithMessage("User Already Exist.");
        }
        try {
            user.persist();
        }catch (Exception e){
            log.error("User creation failed [{}]",user.email);
        }finally {
            log.info("User created successfully [{}]",user.toString());
        }
        return "Done";
    }

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@QueryParam("email") String email, @QueryParam("password") String password) {
        User existingUser = User.find("email", email).firstResult();
        if (existingUser == null || !existingUser.password.equals(password)) {
            log.warn("User not found:" + email);
            throw new WebApplicationException(Response.status(404).entity("No user found or password is incorrect").build());
        }
        return tokenService.generateUserToken(existingUser.email);
    }
}
