package com.diplomski.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CountryDTO(
        Long id,
        String iso2,
        String iso3,
        Integer population,
        String capital,
        String continent,
        String currencyName,
        String currencyCode,
        String phonePrefix
) {

}
