package com.example.elevatemart.exception;

public class InvalidCardException extends RuntimeException{

    public InvalidCardException(String message){
        super(message);
    }
}
