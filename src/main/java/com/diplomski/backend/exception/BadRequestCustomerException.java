package com.diplomski.backend.exception;

public class BadRequestCustomerException  extends RuntimeException{
    public BadRequestCustomerException() {
    }

    public BadRequestCustomerException(String message) {
        super(message);
    }

    public BadRequestCustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestCustomerException(Throwable cause) {
        super(cause);
    }
}
