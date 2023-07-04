package com.diplomski.backend.external.util;

import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.Route;
import com.diplomski.backend.domain.enumeration.FlightStatus;
import com.diplomski.backend.external.dto_external.FlightEDTO;

import java.time.LocalDateTime;
import java.util.Locale;

public class FlightExternalMapper implements ExternalMapper<Flight, FlightEDTO> {
    @Override
    public Flight convertToEntity(FlightEDTO flightEDTO) {
        return new Flight(
                flightEDTO.getDate(),
                FlightStatus.valueOf(flightEDTO.getFlightStatus().toUpperCase(Locale.ROOT)),
                flightEDTO.getDeparture().getGate(),
                flightEDTO.getDeparture().getDelay(),
                 flightEDTO.getDeparture().getScheduled(),
                flightEDTO.getDeparture().getEstimated(),
                flightEDTO.getDeparture().getActual(),
                flightEDTO.getArrival().getGate(),
                flightEDTO.getArrival().getDelay(),
                flightEDTO.getArrival().getScheduled(),
                flightEDTO.getArrival().getEstimated(),
                flightEDTO.getArrival().getActual(),
                flightEDTO.getArrival().getBaggage(),
                LocalDateTime.now(),
                new Airplane(flightEDTO.getAircraft().getIata(),flightEDTO.getAircraft().getIcao24(),flightEDTO.getAircraft().getRegistration()),
                new Route(flightEDTO.getFlight().getNumber())
                        );
    }
}
