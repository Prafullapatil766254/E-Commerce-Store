package com.example.user.service.exceptions.custom;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{
    private final Integer statusCode;

    public UserNotFoundException(String message, Integer statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
