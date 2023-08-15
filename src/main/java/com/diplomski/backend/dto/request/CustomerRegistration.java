package com.diplomski.backend.dto.request;

import java.time.LocalDate;

public record CustomerRegistration(
        String username,
        String email,
        String password,
        String phone,
        String firstName,
        String lastName,
        String birthDate,
        String city,
        String country
) {
}
