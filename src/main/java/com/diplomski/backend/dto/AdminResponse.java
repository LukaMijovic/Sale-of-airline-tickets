package com.diplomski.backend.dto;

public record AdminResponse(
        String token,
        Boolean success
) {
}
