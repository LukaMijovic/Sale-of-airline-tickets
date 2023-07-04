package com.diplomski.backend.external.util;

import com.diplomski.backend.domain.City;
import com.diplomski.backend.domain.Country;
import com.diplomski.backend.external.dto_external.CityEDTO;

public class CityExternalMapper implements ExternalMapper<City, CityEDTO>{
    @Override
    public City convertToEntity(CityEDTO cityEDTO) {
        return new City(cityEDTO.getName(),
                cityEDTO.getIataCode(),
                cityEDTO.getLatitude(),
                cityEDTO.getLongitude(),
                cityEDTO.getTimezone(),
                new Country(cityEDTO.getCountryIso2()));
    }
}
