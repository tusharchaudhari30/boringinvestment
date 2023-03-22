package com.boringinvestment.exception.Mapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException exception) {
        String text = new Scanner(Objects.requireNonNull(this.getClass().getResourceAsStream("/META-INF/resources/index.html")), StandardCharsets.UTF_8).useDelimiter("\\A").next();
        return Response.status(404).entity(text).build();
    }
}