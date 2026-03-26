package com.example.product.service.exceptions.custom;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException{

    private final Integer statusCode;

    public ProductNotFoundException(String message, Integer statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
