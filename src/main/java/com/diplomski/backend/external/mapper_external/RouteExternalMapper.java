package com.diplomski.backend.external.mapper_external;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.domain.Route;
import com.diplomski.backend.external.dto_external.RouteEDTO;

import java.time.LocalDateTime;

public class RouteExternalMapper implements ExternalMapper<Route, RouteEDTO>{
    @Override
    public Route convertToEntity(RouteEDTO routeEDTO) {
        System.out.println(routeEDTO.getDeparture().getActual());
        return new Route(
                routeEDTO.getFlight().getNumber(),
                routeEDTO.getFlight().getIata(),
                routeEDTO.getFlight().getIcao(),
                new Airport(routeEDTO.getDeparture().getAirport(),routeEDTO.getDeparture().getIata(),routeEDTO.getDeparture().getIcao()),
                routeEDTO.getDeparture().getTerminal(),
                routeEDTO.getDeparture().getScheduled()!=null?routeEDTO.getDeparture().getScheduled().toLocalTime():null,
                new Airport(routeEDTO.getArrival().getAirport(),routeEDTO.getArrival().getIata(), routeEDTO.getArrival().getIcao()),
                routeEDTO.getArrival().getTerminal(),
                routeEDTO.getArrival().getScheduled()!=null?routeEDTO.getArrival().getScheduled().toLocalTime():null,
                new Airline(routeEDTO.getAirline().getName(),routeEDTO.getAirline().getIata(),routeEDTO.getAirline().getIcao()),
                LocalDateTime.now(),
                LocalDateTime.now()
                );
    }
}
