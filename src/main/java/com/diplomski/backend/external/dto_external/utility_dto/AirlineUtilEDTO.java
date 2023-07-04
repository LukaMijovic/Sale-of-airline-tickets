package com.diplomski.backend.external.dto_external.utility_dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirlineUtilEDTO {
    String name;
    String callsign;
    String iata;
    String icao;
}
