package com.diplomski.backend.exception;

public class NoSuchElementFoundException extends RuntimeException{
    public NoSuchElementFoundException(String message) {
        super(message);
    }

    public NoSuchElementFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchElementFoundException(Throwable cause) {
        super(cause);
    }

    public NoSuchElementFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
