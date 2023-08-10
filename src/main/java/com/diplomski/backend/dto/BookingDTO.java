package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.ReservationStatus;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record BookingDTO(
        Long id,
        LocalDateTime creationTime,
        LocalDateTime endTime,
        String currency,
        ReservationStatus status,
        Long customerId,
        Long flightId,
        TicketDTO ticket
) {
}
