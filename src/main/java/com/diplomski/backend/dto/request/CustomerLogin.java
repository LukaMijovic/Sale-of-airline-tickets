package com.diplomski.backend.dto.request;

public record CustomerLogin(
        String email,
        String password
) {
}
