package com.diplomski.backend.external.dto_external;

import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.external.dto_external.utility_dto.AircraftUtilEDTO;
import com.diplomski.backend.external.dto_external.utility_dto.AirportUtilEDTO;
import com.diplomski.backend.external.dto_external.utility_dto.FlightUtilEDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightEDTO {
    @JsonProperty(value = "flight_date")
    LocalDate date;
    @JsonProperty(value = "flight_status")
    String flightStatus;
    AirportUtilEDTO departure;
    AirportUtilEDTO arrival;
    FlightUtilEDTO flight;
    AircraftUtilEDTO aircraft;
}
