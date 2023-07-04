package com.diplomski.backend.dto;

import com.diplomski.backend.domain.enumeration.ActiveStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AirplaneDTO(
        Long id,
        String iataType,
        @NotNull(message = "The iata code long must not be a null value")
        String iataCodeLong,
        @NotNull(message = "The iata code short must not be a null value")
        @Size(min=4,max=4,message = "The iata code short has 3 characters")
        String iataCodeShort,
        Integer constructionNumber,
        ActiveStatus activeStatus,
        LocalDateTime deliveryDate,
        LocalDateTime firstFlightDate,
        Integer engineCount,
        String engineType,
        @Size(min = 6,max = 6,message = "The icao code hex must have 4 characters")
        String icaoCodeHex,
        Integer age,
        String planeOwner,
        String registrationNumber,
        String registrationDate,
        AirlineDTO airlineDTO
) {
}
