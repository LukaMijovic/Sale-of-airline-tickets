package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.City;
import com.diplomski.backend.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper implements Mapper<City, CityDTO> {
    @Autowired
    private CountryMapper countryMapper;
    @Override
    public CityDTO entityToDTO(City entity) {
        return new CityDTO(entity.getId(),
                entity.getName(),
                entity.getIataCode(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getTimezone(),
                countryMapper.entityToDTO(entity.getCountry())
                );
    }

    @Override
    public City DTOtoEntity(CityDTO cityDTO) {
        return null;
    }
}
