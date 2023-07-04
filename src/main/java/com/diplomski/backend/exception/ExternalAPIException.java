package com.diplomski.backend.exception;

public class ExternalAPIException extends RuntimeException{
    public ExternalAPIException(String message) {
        super(message);
    }

    public ExternalAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExternalAPIException(Throwable cause) {
        super(cause);
    }

    public ExternalAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
