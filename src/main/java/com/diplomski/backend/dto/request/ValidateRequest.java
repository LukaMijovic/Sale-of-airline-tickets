package com.diplomski.backend.dto.request;

public record ValidateRequest(
        String firstName,
        String lastName,
        String email
) {
}
