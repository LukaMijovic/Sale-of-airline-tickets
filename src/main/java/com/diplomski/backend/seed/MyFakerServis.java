package com.diplomski.backend.seed;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.Route;
import com.diplomski.backend.repository.FlightRepository;
import com.diplomski.backend.seed.flight.FlightFaker;
import com.diplomski.backend.service.AirlineService;
import com.diplomski.backend.service.AirplaneService;
import com.diplomski.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class MyFakerServis {
    private FlightFaker flightFaker;
    @Autowired
    private RouteService routeService;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirplaneService airplaneService;

    public void initFlights(){
        List<Route> routes=routeService.findAll().stream().toList();
        for(Route route: routes){
            flightFaker=new FlightFaker();
            Airplane airplane=flightFaker.getRandomAirplane(airplaneService.findAllByAirline(route.getAirline()));
            try {
                List<Flight> flights=flightFaker.generateFlights(route,airplane);
                flightRepository.saveAll(flights);
            } catch (ParseException e) {
                System.out.println("Excepton: "+e.getMessage());
            }
        }
    }
}
