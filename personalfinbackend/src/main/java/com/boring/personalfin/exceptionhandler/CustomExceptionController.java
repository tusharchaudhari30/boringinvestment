package com.boring.personalfin.exceptionhandler;

import com.boring.personalfin.exception.TokenValidationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomExceptionController {
    @ExceptionHandler(value = TokenValidationFailedException.class)
    public ResponseEntity<Object> exception(TokenValidationFailedException tokenValidationFailedException) {
        log.error(tokenValidationFailedException.getMessage());
        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }
}
