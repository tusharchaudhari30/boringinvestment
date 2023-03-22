package com.boringinvestment.model;

public class ErrorMessage {
    String message;
    Boolean status;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}
