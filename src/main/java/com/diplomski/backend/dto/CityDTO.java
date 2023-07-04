package com.diplomski.backend.dto;

public record CityDTO(
        Long id,
        String name,
        String iataCode,
        Double latitude,
        Double longitude,
        String timezone,
        CountryDTO countryDTO
) {
}
