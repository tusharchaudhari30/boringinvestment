package com.boring.personalfin.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserCustomException extends RuntimeException {
    public UserCustomException(String message) {
        super(message);
    }
}
