package com.example.product.service.exceptions;

import com.example.product.service.exceptions.custom.ProductNotFoundException;
import com.example.product.service.exceptions.custom.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleProductNotFoundException(ProductNotFoundException exception){
        return new ResponseEntity<>(ResponseMessage.builder()
                .message(exception.getMessage())
                .statusCode(exception.getStatusCode())
                .build(),
                HttpStatus.NOT_FOUND
                );
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ResponseMessage> handleValidationException(ValidationException exception){
        return new ResponseEntity<>(ResponseMessage.builder()
                .message(exception.getMessage())
                .statusCode(exception.getStatusCode())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
