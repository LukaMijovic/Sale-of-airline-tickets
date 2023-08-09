package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.FlightDTOActive2;
import org.springframework.stereotype.Component;

@Component
public class FlightActive2Mapper implements Mapper<Flight, FlightDTOActive2> {
    @Override
    public FlightDTOActive2 entityToDTO(Flight entity) {
        return new FlightDTOActive2(
                entity.getId(),
                entity.getFlightDate(),
                entity.getDepScheduled(),
                entity.getArrScheduled(),
                entity.getRoute().getAirline().getName(),
                entity.getRoute().getAirline().getImage(),
                entity.getRoute().getDepartureAirport().getIataCode(),
                entity.getRoute().getArrivalAirport().getCity().getName(),
                entity.getRoute().getArrivalAirport().getIataCode(),
                entity.getRoute().getArrivalAirport().getCity().getName()
        );
    }

    @Override
    public Flight DTOtoEntity(FlightDTOActive2 flightDTOActive2) {
        return null;
    }
}
