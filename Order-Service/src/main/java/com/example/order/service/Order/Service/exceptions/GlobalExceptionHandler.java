package com.example.order.service.Order.Service.exceptions;

import com.example.order.service.Order.Service.exceptions.custom.OrderNotFoundException;
import com.example.order.service.Order.Service.exceptions.custom.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ResponseMessage> handleValidationException(ValidationException exception){
        return new ResponseEntity<>(ResponseMessage.builder()
                .message(exception.getMessage())
                .statusCode(exception.getStatusCode())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleOrderNotFoundException(OrderNotFoundException exception){
        return new ResponseEntity<>(ResponseMessage.builder()
                .message(exception.getMessage())
                .statusCode(exception.getStatusCode())
                .build(), HttpStatus.NOT_FOUND);
    }

}
