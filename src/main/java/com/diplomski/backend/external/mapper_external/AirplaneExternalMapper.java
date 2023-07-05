package com.diplomski.backend.external.mapper_external;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.enumeration.ActiveStatus;
import com.diplomski.backend.external.dto_external.AirplaneEDTO;

public class AirplaneExternalMapper implements ExternalMapper<Airplane, AirplaneEDTO>{
    @Override
    public Airplane convertToEntity(AirplaneEDTO airplaneEDTO) {
        return new Airplane(airplaneEDTO.getIataType(),
                airplaneEDTO.getIataCodeLong(),
                airplaneEDTO.getIataCodeShort(),
                airplaneEDTO.getActiveStatus().contains("active")? ActiveStatus.ACTIVE:ActiveStatus.HISTORICAL,
                airplaneEDTO.getConstructionNumber(),
                airplaneEDTO.getDeliveryDate(),
                airplaneEDTO.getFirstFlightDate(),
                airplaneEDTO.getEngineCount(),
                airplaneEDTO.getEngineType(),
                airplaneEDTO.getIcaoCodeHex(),
                airplaneEDTO.getAge(),
                airplaneEDTO.getPlaneOwner(),
                airplaneEDTO.getRegistrationNumber(),
                airplaneEDTO.getDeliveryDate(),
                new Airline(airplaneEDTO.getAirlineIata()));
    }
}
