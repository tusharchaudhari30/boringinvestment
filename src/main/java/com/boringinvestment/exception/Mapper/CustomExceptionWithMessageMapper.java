package com.boringinvestment.exception.Mapper;

import com.boringinvestment.exception.Declaration.CustomExceptionWithMessage;
import com.boringinvestment.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionWithMessageMapper implements ExceptionMapper<CustomExceptionWithMessage> {

    @Override
    public Response toResponse(CustomExceptionWithMessage exception) {
        return Response.status(500).entity(exception.getMessage()).build();
    }
}
