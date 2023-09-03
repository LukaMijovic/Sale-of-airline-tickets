package com.diplomski.backend.dto;

public record BookingAdmin(
        Long id,
        String status,
        Long customerId,
        Long flightId
) {
}
