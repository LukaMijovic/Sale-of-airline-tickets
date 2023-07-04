package com.diplomski.backend.external.dto_external;

import com.diplomski.backend.domain.enumeration.ActiveStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

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
    Integer constructionNumber;
    @JsonProperty(value = "plane_status")
    String activeStatus;
    @JsonProperty(value = "delivery_date")
    LocalDateTime deliveryDate;
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
    @JsonProperty(value = "registration_date")
    String registrationDate;
    @JsonProperty(value = "airline_iata_code")
    String airlineIata;
    @JsonProperty(value = "airline_icao_code")
    String airlineIcao;
}
