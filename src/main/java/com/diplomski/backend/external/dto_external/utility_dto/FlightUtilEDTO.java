package com.diplomski.backend.external.dto_external.utility_dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightUtilEDTO {
    Integer number;
    String iata;
    String icao;
}
