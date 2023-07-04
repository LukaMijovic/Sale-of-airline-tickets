package com.diplomski.backend.external.dto_external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryEDTO {
    @JsonProperty(value = "country_name")
    String name;
    @JsonProperty(value = "country_iso2")
    String iso2;
    @JsonProperty(value = "country_iso3")
    String iso3;
    Integer population;
    String capital;
    String continent;
    @JsonProperty(value = "currency_name")
    String currencyName;
    @JsonProperty(value = "currency_code")
    String currencyCode;
    @JsonProperty(value = "phone_prefix")
    String phonePrefix;
}
