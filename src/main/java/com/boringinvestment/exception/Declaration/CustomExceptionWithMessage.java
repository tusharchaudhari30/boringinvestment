package com.boringinvestment.exception.Declaration;

public class CustomExceptionWithMessage extends RuntimeException {
    public CustomExceptionWithMessage(String message) {
        super(message);
    }
}