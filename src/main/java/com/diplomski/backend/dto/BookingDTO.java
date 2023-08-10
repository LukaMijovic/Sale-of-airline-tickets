package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.ReservationStatus;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

public record BookingDTO(
        Long id,
        LocalDateTime creationTime,
        LocalDateTime endTime,
        String currency,
        ReservationStatus status,
        Long customerId,
        Long flightId,
        List<TicketDTO> tickets
) {
}
