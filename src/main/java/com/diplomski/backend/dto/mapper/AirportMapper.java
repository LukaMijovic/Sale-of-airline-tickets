package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.dto.AirportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper implements Mapper<Airport, AirportDTO> {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CountryMapper countryMapper;
    @Override
    public AirportDTO entityToDTO(Airport entity) {
        return new AirportDTO(
                entity.getId(),
                entity.getName(),
                entity.getIataCode(),
                entity.getIcaoCode(),
               entity.getCity().getName()+","+entity.getCountry().getName()
               // entity.getLatitude(),
                //entity.getLongitude(),
                //entity.getPhoneNumber(),
                //countryMapper.entityToDTO(entity.getCountry()),
                //cityMapper.entityToDTO(entity.getCity())
                );
    }

    @Override
    public Airport DTOtoEntity(AirportDTO airportDTO) {
        return null;
    }
}
