package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.FlightStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FlightDTOActive2(
        Long id,
        LocalDate flightDate,
        String departureScheduled,
        String arrivalScheduled,
        String airlineName,
        String airlineImage,
        String iataCodeDep,
        String airportCityDep,
        String iataCodeArr,
        String airportCityArr
) {
}
