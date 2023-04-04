package com.example.account.exception;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException() {
    }

    public CustomNotFoundException(String message) {
        super(message);
    }

    public CustomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
