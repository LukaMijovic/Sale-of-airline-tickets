package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.FlightStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FlightDTOActive(
        Long id,
        LocalDate flightDate,
        FlightStatus flightStatus,
        String departureGate,
        LocalDateTime departureScheduled,
        LocalDateTime departureEstimated,
        String arrivalGate,
        LocalDateTime arrivalScheduled,
        LocalDateTime arrivalEstimated,
        String baggage,
        LocalDateTime updateFlight,
        String registrationNumber,
        String airlineName,
        String airlineImage,
        String iataCodeDep,
        String airportCityDep,
        String iataCodeArr,
        String airportCityArr
) {
}
