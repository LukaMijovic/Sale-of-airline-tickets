package com.diplomski.backend.dto.request;

public record BookingRequest(
        Long flightId,
        Long customerId,
        String seatClass
) {
}
