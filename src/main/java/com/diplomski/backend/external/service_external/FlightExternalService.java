package com.diplomski.backend.external.service_external;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.Route;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.external.dto_external.FlightEDTO;
import com.diplomski.backend.repository.FlightRepository;
import com.diplomski.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FlightExternalService extends ExternalService<Flight, FlightEDTO> {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private RouteService routeService;
    @Override
    List<Flight> saveObjects(List<Flight> list) {
        System.out.println(list==null);
        return flightRepository.saveAll(
                list.stream()
                        //.filter(flight -> flight.getRoute().getFlight()!=null)
                        .map(flight -> {
                            try{
                                System.out.println(1);
                                Route route=routeService.findByFlightNumber(flight.getRoute());
                                flight.setRoute(route);
                                System.out.println(1);
                                return flight;
                            }catch (NoSuchElementFoundException ex){
                                return null;
                            }
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
        );
    }

    @Override
    protected FlightEDTO trimList(FlightEDTO flightEDTO) {
        return flightEDTO;
    }
}
