package com.example.order.service.Order.Service.exceptions.enums;

public enum CustomStatusCode {

    VALIDATION_EXCEPTION(100),
    ORDER_NOT_FOUND(301);

    private final int code;

    CustomStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
