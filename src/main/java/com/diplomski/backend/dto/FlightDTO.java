package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.FlightStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FlightDTO(
        Long id,
        LocalDate flightDate,
        FlightStatus flightStatus,
        String departureGate,
        Integer departureDelay,
        LocalDateTime departureScheduled,
        LocalDateTime departureEstimated,
        LocalDateTime departureActual,
        String arrivalGate,
        Integer arrivalDelay,
        LocalDateTime arrivalScheduled,
        LocalDateTime arrivalEstimated,
        LocalDateTime arrivalActual,
        String baggage,
        LocalDateTime updateFlight,
        AirplaneDTO airplane

) {
}
