package com.diplomski.backend.external.mapper_external;

import com.diplomski.backend.domain.Country;
import com.diplomski.backend.external.dto_external.CountryEDTO;

public class CountryExternalMapper implements ExternalMapper<Country, CountryEDTO>{
    @Override
    public Country convertToEntity(CountryEDTO countryEDTO) {
        return new Country(countryEDTO.getName(),
                countryEDTO.getIso2(),
                countryEDTO.getIso3(),
                countryEDTO.getPopulation(),
                countryEDTO.getCapital(),
                countryEDTO.getContinent(),
                countryEDTO.getCurrencyName(),
                countryEDTO.getCurrencyCode(),
                countryEDTO.getPhonePrefix());
    }
}
