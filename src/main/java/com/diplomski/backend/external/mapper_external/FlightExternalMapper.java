package com.diplomski.backend.external.mapper_external;

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
        System.out.println(flightEDTO.getFlight());
        System.out.println(flightEDTO.getDeparture());
        System.out.println(flightEDTO.getFlight().getNumber());
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
                LocalDateTime.now(),
                flightEDTO.getAircraft()!=null?
                        new Airplane(flightEDTO.getAircraft().getIata(),flightEDTO.getAircraft().getIcao24(),flightEDTO.getAircraft().getRegistration())
                :null,
                new Route(flightEDTO.getFlight().getNumber())
                        );
    }
}
