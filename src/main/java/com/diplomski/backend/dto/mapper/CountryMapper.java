package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Country;
import com.diplomski.backend.dto.CountryDTO;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper implements Mapper<Country, CountryDTO> {

    @Override
    public CountryDTO entityToDTO(Country entity) {
        return new CountryDTO(entity.getId(),
                entity.getName(),
                entity.getIso2Code(),
                entity.getIso3Code(),
                entity.getPopulation(),
                entity.getCapital(),
                entity.getContinent(),
                entity.getCurrencyName(),
                entity.getCurrencyCode(),
                entity.getPhonePrefix());
    }

    @Override
    public Country DTOtoEntity(CountryDTO countryDTO) {
        return null;
    }
}
