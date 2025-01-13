package com.ducktrung.learningspingboot.Exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized exception"),
    USER_EXISTED(1001, "User existed"),
    USERNAME_INVALID(1002, "Username must be at leats 3 characters"),
    INVALID_PASSWORD(1003, "Password must be at leats 8 characters"),
    INVALID_KEY(1004,"Invalid message key"),
    USER_NOT_EXISTED(1005, "User not existed")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
