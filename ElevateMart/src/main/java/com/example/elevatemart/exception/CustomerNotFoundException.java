package com.example.elevatemart.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){

        super(message);
    }
}
