package com.diplomski.backend.external.util;

import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.domain.City;
import com.diplomski.backend.domain.Country;
import com.diplomski.backend.external.dto_external.AirportEDTO;

public class AirportExternalMapper implements ExternalMapper<Airport, AirportEDTO>{
    @Override
    public Airport convertToEntity(AirportEDTO airportEDTO) {
        return new Airport(airportEDTO.getName(),
                airportEDTO.getIataCode(),
                airportEDTO.getIcaoCode(),
                airportEDTO.getLatitude(),
                airportEDTO.getLongitude(),
                airportEDTO.getPhoneNumber(),
                new Country(airportEDTO.getCountryName(), airportEDTO.getCountryIso2()),
                new City(airportEDTO.getCityIataCode()));
    }
}
