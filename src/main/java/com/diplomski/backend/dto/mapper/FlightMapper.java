package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.FlightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper implements Mapper<Flight, FlightDTO> {
    @Autowired
    private AirplaneMapper airplaneMapper;
    @Autowired
    private RouteMapper routeMapper;
    @Override
    public FlightDTO entityToDTO(Flight entity) {
        return new FlightDTO(entity.getId(),
                entity.getFlightDate(),
                entity.getFlightStatus(),
                entity.getDepGate(),
                entity.getDepDelay(),
                entity.getDepScheduled(),
                entity.getDepEstimated(),
                entity.getDepActual(),
                entity.getArrGate(),
                entity.getArrDelay(),
                entity.getArrScheduled(),
                entity.getArrEstimated(),
                entity.getArrActual(),
                entity.getBaggage(),
                entity.getUpdatedFlight(),
                airplaneMapper.entityToDTO(entity.getAirplane()),
                routeMapper.entityToDTO(entity.getRoute()));
    }

    @Override
    public Flight DTOtoEntity(FlightDTO flightDTO) {
        return null;
    }
}
