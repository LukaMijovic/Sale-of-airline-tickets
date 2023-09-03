package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.domain.Route;
import com.diplomski.backend.dto.request.RouteRequest;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.external.dto_external.RouteEDTO;
import com.diplomski.backend.external.service_external.ExternalService;
import com.diplomski.backend.repository.RouteRepository;
import com.diplomski.backend.service.AirlineService;
import com.diplomski.backend.service.AirportService;
import com.diplomski.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteServiceImp implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private AirportService airportService;
    @Autowired
    private AirlineService airlineService;
    @Override
    public Route findByFlightNumber(Route route)throws NoSuchElementFoundException {
        Optional<Route> optionalRoute=routeRepository.findByFlight(route.getFlight());
        if(!optionalRoute.isPresent()){
            throw new NoSuchElementFoundException("The route with number "+route.getFlight()+" does not exist");
        }
        return route;
    }

    @Override
    public boolean existRoute(Route route) throws NoSuchElementFoundException {
        try {
            findByFlightNumber(route);
            return true;
        }catch (NoSuchElementFoundException ex){
            return false;
        }

    }

    @Override
    public Page<Route> findAll() {
        return routeRepository.findAll(PageRequest.of(0,30));
    }

    @Override
    public Route createRoute(RouteRequest routeRequest) throws NoSuchElementFoundException {
        Airport depAirport=airportService.findById(routeRequest.depAirportId());
        Airport arrAirport=airportService.findById(routeRequest.arrAirportId());
        Airline airline=airlineService.findById(routeRequest.airlineId());

        Route route=new Route();
        route.setAirline(airline);
        route.setDepartureAirport(depAirport);
        route.setArrivalAirport(arrAirport);
        route.setDepartureTerminal(routeRequest.depTerminal());
        route.setArrivalTerminal(routeRequest.arrTerminal());
        route.setDepartureTime(LocalTime.parse(routeRequest.depTime(), DateTimeFormatter.ofPattern("HH:mm")));
        route.setArrivalTime(LocalTime.parse(routeRequest.arrTime(), DateTimeFormatter.ofPattern("HH:mm")));
        route.setCreatedDate(LocalDateTime.now());
        route.setFlight(new Random().nextInt(9999)+1);
        route.setIataFlight(airline.getIataCode()+route.getFlight());
        route.setIcaoFlight(airline.getIcaoCode()+route.getFlight());

        return routeRepository.save(route);
    }
}
