package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.ActiveStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AirlineDTO(
        Long id,
        @NotNull
        String name,
        @Size(min = 2,max = 2,message = "Iata code have 2 characters")
        String iataCode,
        @Size(min = 3,max = 3,message = "Icao code have 2 characters")
        String icaoCode,
        String callsign,
        ActiveStatus activeStatus,
        String fleetSize,
        String fleetAverageAge,
        Integer yearFounded,
        String image
) {
}
