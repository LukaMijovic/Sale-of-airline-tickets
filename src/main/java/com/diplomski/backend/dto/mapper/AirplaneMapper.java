package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.dto.AirplaneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirplaneMapper implements Mapper<Airplane, AirplaneDTO> {
    @Autowired
    private AirlineMapper airlineMapper;
    @Override
    public AirplaneDTO entityToDTO(Airplane entity) {
        return new AirplaneDTO(entity.getId(),
                entity.getIataType(),
                entity.getIataCodeLong(),
                entity.getIataCodeShort(),
                entity.getConstructionNumber(),
                entity.getActiveStatus(),
                entity.getDeliveryDate(),
                entity.getFirstFlightDate(),
                entity.getEngineCount(),
                entity.getEngineType(),
                entity.getIcaoCodeHex(),
                entity.getAge(),
                entity.getPlaneOwner(),
                entity.getRegistrationNumber(),
                entity.getRegistrationDate(),
                airlineMapper.entityToDTO(entity.getAirline())
                );
    }

    @Override
    public Airplane DTOtoEntity(AirplaneDTO airplaneDTO) {
        return null;
    }
}
