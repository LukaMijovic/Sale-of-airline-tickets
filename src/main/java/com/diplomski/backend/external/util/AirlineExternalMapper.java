package com.diplomski.backend.external.util;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Country;
import com.diplomski.backend.domain.enumeration.ActiveStatus;
import com.diplomski.backend.external.dto_external.AirlineEDTO;

public class AirlineExternalMapper implements ExternalMapper<Airline, AirlineEDTO>{
    @Override
    public Airline convertToEntity(AirlineEDTO airlineEDTO) {
        return new Airline(airlineEDTO.getName(),
                airlineEDTO.getIataCode(),
                airlineEDTO.getIcaoCode(),
                airlineEDTO.getCallsign(),
                airlineEDTO.getStatus().contains("active")? ActiveStatus.ACTIVE:ActiveStatus.HISTORICAL,
                airlineEDTO.getFleetSize(),
                airlineEDTO.getFleetAverageAge(),
                airlineEDTO.getYearFounded(),
                null,
                new Country(airlineEDTO.getCountryName(), airlineEDTO.getCountryIso2()));
    }
}
