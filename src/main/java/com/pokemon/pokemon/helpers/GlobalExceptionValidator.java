package com.pokemon.pokemon.helpers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionValidator {

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<?> handleException(Exception exception) {
        return ResponseEntity.internalServerError().body("Something wrong occurred in the server");
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNotFoundException() {

        return ResponseEntity.notFound().build();
    }
}
