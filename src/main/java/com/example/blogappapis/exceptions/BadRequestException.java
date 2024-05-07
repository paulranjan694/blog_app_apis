package com.example.blogappapis.exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}
