package com.diplomski.backend.external.dto_external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirportEDTO {
    @JsonProperty(value = "airport_name")
    String name;
    @JsonProperty(value = "iata_code")
    String iataCode;
    @JsonProperty(value = "icao_code")
    String icaoCode;
    Double latitude;
    Double longitude;
    @JsonProperty(value = "phone_number")
    String phoneNumber;
    @JsonProperty(value = "country_iso2")
    String countryIso2;
    @JsonProperty(value = "country_name")
    String countryName;
    @JsonProperty(value = "city_iata_code")
    String cityIataCode;
}
