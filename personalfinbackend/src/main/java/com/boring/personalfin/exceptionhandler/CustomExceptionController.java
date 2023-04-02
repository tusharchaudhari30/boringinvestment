package com.boring.personalfin.exceptionhandler;

import com.boring.personalfin.exception.TokenValidationFailedException;
import com.boring.personalfin.exception.UserCustomException;
import com.boring.personalfin.model.dto.ExceptionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomExceptionController {
    @ExceptionHandler(value = TokenValidationFailedException.class)
    public ResponseEntity<ExceptionMessage> exception(TokenValidationFailedException tokenValidationFailedException) {
        return new ResponseEntity<>(new ExceptionMessage(HttpStatus.UNAUTHORIZED, tokenValidationFailedException.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = UserCustomException.class)
    public ResponseEntity<ExceptionMessage> exception(UserCustomException userCustomException) {
        return new ResponseEntity<>(new ExceptionMessage(HttpStatus.UNAUTHORIZED, userCustomException.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
