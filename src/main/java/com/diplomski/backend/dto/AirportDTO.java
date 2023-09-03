package com.diplomski.backend.dto;

public record AirportDTO(
        Long id,
        String name,
        String iataCode,
        String icaoCode,
        String cityCountry
        //Double latitude,
        //Double longitude,
        //String phoneNumber,
        //CountryDTO countryDTO,
        //CityDTO cityDTO
) {
}
