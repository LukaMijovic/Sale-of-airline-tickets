package com.diplomski.backend.exception;

public class BadRequestAirportException extends RuntimeException {
    public BadRequestAirportException() {
    }

    public BadRequestAirportException(String message) {
        super(message);
    }

    public BadRequestAirportException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestAirportException(Throwable cause) {
        super(cause);
    }
}
