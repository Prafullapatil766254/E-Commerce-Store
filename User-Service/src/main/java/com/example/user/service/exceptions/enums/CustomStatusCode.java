package com.example.user.service.exceptions.enums;

public enum CustomStatusCode {

    VALIDATION_EXCEPTION(100),
    USER_NOT_FOUND(101);

    private final int code;

    CustomStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
