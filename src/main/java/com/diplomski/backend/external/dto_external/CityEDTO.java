package com.diplomski.backend.external.dto_external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityEDTO {
    @JsonProperty(value = "city_name")
    String name;
    @JsonProperty(value = "iata_code")
    String iataCode;
    Double latitude;
    Double longitude;
    String timezone;
    @JsonProperty(value = "country_iso2")
    String countryIso2;
}
