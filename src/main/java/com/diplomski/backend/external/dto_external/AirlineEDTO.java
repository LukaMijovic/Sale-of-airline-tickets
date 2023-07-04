package com.diplomski.backend.external.dto_external;

import com.diplomski.backend.domain.enumeration.ActiveStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirlineEDTO {
    @JsonProperty(value = "airline_name")
    String name;
    @JsonProperty(value = "iata_code")
    String iataCode;
    @JsonProperty(value = "icao_code")
    String icaoCode;
    String callsign;
    String status;
    @JsonProperty(value = "fleet_size")
    Integer fleetSize;
    @JsonProperty(value = "fleet_average_age")
    Double fleetAverageAge;
    @JsonProperty(value = "date_founded")
    Integer yearFounded;
    @JsonProperty(value = "country_name")
    String countryName;
    @JsonProperty(value = "country_iso2")
    String countryIso2;
}
