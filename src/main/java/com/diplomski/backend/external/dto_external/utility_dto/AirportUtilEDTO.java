package com.diplomski.backend.external.dto_external.utility_dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirportUtilEDTO {
    String airport;
    String iata;
    String icao;
    String terminal;
    LocalTime time;
    String gate;
    Integer delay;
    LocalDateTime scheduled;
    LocalDateTime estimated;
    LocalDateTime actual;
    String baggage;
}
