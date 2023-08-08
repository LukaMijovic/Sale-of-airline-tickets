package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.FlightDTOActive;
import org.springframework.stereotype.Component;

@Component
public class FlightActiveMapper implements Mapper<Flight, FlightDTOActive> {
    @Override
    public FlightDTOActive entityToDTO(Flight entity) {
        return new FlightDTOActive(
                entity.getId(),
                entity.getFlightDate(),
                entity.getFlightStatus(),
                entity.getDepGate(),
                entity.getDepScheduled(),
                entity.getDepEstimated(),
                entity.getArrGate(),
                entity.getArrScheduled(),
                entity.getArrEstimated(),
                entity.getBaggage(),
                entity.getUpdatedFlight(),
                entity.getAirplane().getRegistrationNumber(),
                entity.getRoute().getAirline().getName(),
                entity.getRoute().getAirline().getImage(),
                entity.getRoute().getDepartureAirport().getName(),
                entity.getRoute().getDepartureAirport().getCity().getName(),
                entity.getRoute().getArrivalAirport().getName(),
                entity.getRoute().getArrivalAirport().getCity().getName()
        );
    }

    @Override
    public Flight DTOtoEntity(FlightDTOActive flightDTOActive) {
        return null;
    }
}
