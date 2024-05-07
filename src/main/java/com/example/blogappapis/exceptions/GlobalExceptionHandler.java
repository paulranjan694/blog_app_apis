package com.example.blogappapis.exceptions;

import com.example.blogappapis.exchanges.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
       ExceptionResponse exceptionResponse = ExceptionResponse.builder().status(false).message(resourceNotFoundException.getMessage()).build();
       return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> badRequestExceptionHandler(BadRequestException badRequestException){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().status(false).message(badRequestException.getMessage()).build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
