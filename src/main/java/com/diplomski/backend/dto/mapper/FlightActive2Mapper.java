package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.FlightDTOActive2;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class FlightActive2Mapper implements Mapper<Flight, FlightDTOActive2> {
    @Override
    public FlightDTOActive2 entityToDTO(Flight entity) {
        return new FlightDTOActive2(
                entity.getId(),
                entity.getFlightDate(),
                entity.getDepScheduled()!=null?entity.getDepScheduled().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")):null,
                entity.getArrScheduled()!=null?entity.getArrScheduled().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")):null,
                entity.getRoute().getAirline().getName(),
                entity.getRoute().getAirline().getImage(),
                entity.getRoute().getDepartureAirport().getIataCode(),
                entity.getRoute().getDepartureAirport().getCity().getName(),
                entity.getRoute().getArrivalAirport().getIataCode(),
                entity.getRoute().getArrivalAirport().getCity().getName()
        );
    }

    @Override
    public Flight DTOtoEntity(FlightDTOActive2 flightDTOActive2) {
        return null;
    }
}
