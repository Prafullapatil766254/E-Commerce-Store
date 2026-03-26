package com.example.product.service.exceptions.custom;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException{

    private final Integer statusCode;

    public ValidationException(String message, Integer statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}