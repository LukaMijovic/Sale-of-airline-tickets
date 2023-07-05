package com.diplomski.backend.external.dto_external;

import com.diplomski.backend.config.MyLocaDateTimeDesirializer;
import com.diplomski.backend.domain.enumeration.ActiveStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirplaneEDTO {
    @JsonProperty(value = "iata_type")
    String iataType;
    @JsonProperty(value = "iata_code_long")
    String iataCodeLong;
    @JsonProperty(value = "iata_code_short")
    String iataCodeShort;
    @JsonProperty(value = "construction_number")
    String constructionNumber;
    @JsonProperty(value = "plane_status")
    String activeStatus;
    @JsonDeserialize(using = MyLocaDateTimeDesirializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty(value = "delivery_date")
    LocalDateTime deliveryDate;
    @JsonDeserialize(using = MyLocaDateTimeDesirializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty(value = "first_flight_date")
    LocalDateTime firstFlightDate;
    @JsonProperty(value = "engine_count")
    Integer engineCount;
    @JsonProperty(value = "engine_type")
    String engineType;
    @JsonProperty(value = "iata_code_hex")
    String icaoCodeHex;
    @JsonProperty(value = "plane_age")
    Integer age;
    @JsonProperty(value = "plane_owner")
    String planeOwner;
    @JsonProperty(value = "registration_number")
    String registrationNumber;
    @JsonDeserialize(using = MyLocaDateTimeDesirializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty(value = "registration_date")
    LocalDateTime registrationDate;
    @JsonProperty(value = "airline_iata_code")
    String airlineIata;
    @JsonProperty(value = "airline_icao_code")
    String airlineIcao;
}
