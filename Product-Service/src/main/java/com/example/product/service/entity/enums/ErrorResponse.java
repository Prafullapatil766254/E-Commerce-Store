package com.example.product.service.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author Prafull_Patil
 * Error response enum for custom codes and messages
 */
@Getter
@AllArgsConstructor
public enum ErrorResponse {

    VALIDATION_ERROR(101 , HttpStatus.BAD_REQUEST),

    UNPROCESSABLE_ENTITY(102, HttpStatus.UNPROCESSABLE_ENTITY);

    private final int code;

    private final HttpStatus httpStatus;
}
