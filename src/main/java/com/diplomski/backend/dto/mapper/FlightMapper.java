package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.FlightDTO;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper implements Mapper<Flight, FlightDTO> {
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
                null);
    }

    @Override
    public Flight DTOtoEntity(FlightDTO flightDTO) {
        return null;
    }
}
