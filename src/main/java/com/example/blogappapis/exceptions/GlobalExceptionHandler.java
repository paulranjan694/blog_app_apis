package com.example.blogappapis.exceptions;

import com.example.blogappapis.exchanges.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> resp = new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
            String feildName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            resp.put(feildName,message);
        });

        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }
}
