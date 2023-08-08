package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.AccountStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CustomerDTO(
        Long id,
        String username,
        String email,
        String password,
        String phone,
        String firstName,
        String lastName,
        LocalDate birthDate,
        String city,
        String country,
        AccountStatus accountStatus,
        LocalDateTime registrationTime,
        LocalDateTime lastEditTime
) {
}
