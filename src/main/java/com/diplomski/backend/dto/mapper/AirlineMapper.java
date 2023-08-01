package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.dto.AirlineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirlineMapper implements Mapper<Airline, AirlineDTO> {
    @Autowired
    private CountryMapper countryMapper;
    @Override
    public AirlineDTO entityToDTO(Airline entity) {
        return new AirlineDTO(entity.getId(),
                entity.getName(),
                entity.getIataCode(),
                entity.getIcaoCode(),
                entity.getCallsign(),
                entity.getActiveStatus(),
                entity.getFleetSize(),
                entity.getFleetAvgAge(),
                entity.getYearFounded(),
                countryMapper.entityToDTO(entity.getCountry()),
                entity.getImage());
    }

    @Override
    public Airline DTOtoEntity(AirlineDTO airlineDTO) {
        return null;
    }
}
