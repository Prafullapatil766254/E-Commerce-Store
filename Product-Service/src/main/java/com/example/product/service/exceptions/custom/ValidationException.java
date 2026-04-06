package com.example.product.service.exceptions.custom;

import com.example.product.service.entity.enums.ErrorResponse;
import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException{

    private final ErrorResponse errorResponse;

    public ValidationException(String message, ErrorResponse errorResponse){
        super(message);
        this.errorResponse = errorResponse;
    }
}