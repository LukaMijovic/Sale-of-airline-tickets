package com.diplomski.backend.external.dto_external.utility_dto;

import com.diplomski.backend.config.MyLocaDateTimeDesirializer;
import com.diplomski.backend.config.MyLocalDateTimeOffsetDesirializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonDeserialize(using = MyLocalDateTimeOffsetDesirializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime scheduled;
    @JsonDeserialize(using = MyLocalDateTimeOffsetDesirializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime estimated;
    @JsonDeserialize(using =  MyLocalDateTimeOffsetDesirializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime actual;
    String baggage;
}
