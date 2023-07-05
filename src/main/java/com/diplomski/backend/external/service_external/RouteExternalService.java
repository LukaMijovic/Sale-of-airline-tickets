package com.diplomski.backend.external.service_external;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.domain.Route;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.external.dto_external.RouteEDTO;
import com.diplomski.backend.repository.RouteRepository;
import com.diplomski.backend.service.AirlineService;
import com.diplomski.backend.service.AirportService;
import com.diplomski.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RouteExternalService extends ExternalService<Route, RouteEDTO> {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private RouteService routeService;
    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirportService airportService;
    @Override
    List<Route> saveObjects(List<Route> list) {
        return routeRepository.saveAll(
                list.stream()
                        .filter(route -> route.getFlight()!=null)
                        .filter(route -> route.getAirline()!=null)
                        .filter(route -> route.getArrivalAirport()!=null && route.getDepartureAirport()!=null)
                        .filter(route -> !routeService.existRoute(route))
                        .map(route -> {
                            try{
                                Airline airline=airlineService.findByIataCode(route.getAirline());
                                Airport arrival=airportService.findByIataCode(route.getArrivalAirport());
                                Airport departure=airportService.findByIataCode(route.getDepartureAirport());

                                route.setAirline(airline);
                                route.setArrivalAirport(arrival);
                                route.setDepartureAirport(departure);

                                return route;
                            }catch (NoSuchElementFoundException ex){
                                return null;
                            }
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
        );
    }
}
