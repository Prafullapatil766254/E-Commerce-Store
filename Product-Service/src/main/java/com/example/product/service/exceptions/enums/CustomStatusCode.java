package com.example.product.service.exceptions.enums;

public enum CustomStatusCode {

    VALIDATION_EXCEPTION(100),
    PRODUCT_NOT_FOUND(201);

    private final int code;

    CustomStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}