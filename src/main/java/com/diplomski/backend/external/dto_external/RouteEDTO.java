package com.diplomski.backend.external.dto_external;

import com.diplomski.backend.external.dto_external.utility_dto.AirlineUtilEDTO;
import com.diplomski.backend.external.dto_external.utility_dto.AirportUtilEDTO;
import com.diplomski.backend.external.dto_external.utility_dto.FlightUtilEDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteEDTO {

    AirportUtilEDTO departure;
    AirportUtilEDTO arrival;
    AirlineUtilEDTO airline;
    FlightUtilEDTO flight;
}
