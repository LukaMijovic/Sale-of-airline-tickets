package com.diplomski.backend.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record RouteDTO(
        Long id,
        @NotNull(message = "The flight has to a non null value")
        Integer flight,
        String iataFlight,
        String icaoFlight,
        AirportDTO departureAirport,
        String departureTerminal,
        LocalTime departureTime,
        AirportDTO arrivalAirport,
        String arrivalTerminal,
        LocalTime arrivalTime,
        AirlineDTO airline,
        LocalDateTime creationDate,
        LocalDateTime updateDate
) {
}
