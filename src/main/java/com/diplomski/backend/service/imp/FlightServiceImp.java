package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.domain.City;
import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.enumeration.FlightStatus;
import com.diplomski.backend.dto.request.FlightRequest;
import com.diplomski.backend.exception.BadRequestAirportException;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.FlightRepository;
import com.diplomski.backend.service.AirportService;
import com.diplomski.backend.service.CityService;
import com.diplomski.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightServiceImp implements FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private CityService cityService;
    @Autowired
    private AirportService airportService;

    @Override
    public Flight findByFlightNumber(Flight flight) throws NoSuchElementFoundException {
        Optional<Flight> optionalFlight=flightRepository.findByRouteFlight(flight.getRoute().getFlight());
        if(!optionalFlight.isPresent()){
            throw new NoSuchElementFoundException("Flight with this route does not exist");
        }
        return optionalFlight.get();
    }

    @Override
    public Page<Flight> getAllFlights(int pageNo) {
        Pageable pageable= PageRequest.of(pageNo,10);
        return flightRepository.findAll(pageable);
    }

    @Override
    public Page<Flight> getActiveFlights(int pageNo) {
        Pageable pageable=PageRequest.of(pageNo,10);
        return flightRepository.findByFlightStatus(FlightStatus.ACTIVE,pageable);
    }

    @Override
    public Page<Flight> getScheduledFlights(int pageNo) {
        Pageable pageable=PageRequest.of(pageNo,10);
        return flightRepository.findByFlightStatus(FlightStatus.SCHEDULED,pageable);
    }

    @Override
    public Page<Flight> findActiveFlights(FlightRequest flightRequest, int pageNo) throws BadRequestAirportException {
        Pageable pageable=PageRequest.of(pageNo,10);
        City cityDep;
        City cityArr;
        try{
            cityDep=cityService.findByName(flightRequest.cityDep());
        }catch (NoSuchElementFoundException ex){
            throw new BadRequestAirportException("The departure city does not exist in database");
        }
        try{
            cityArr=cityService.findByName(flightRequest.cityDep());
        }catch (NoSuchElementFoundException ex){
            throw new BadRequestAirportException("The arrival city does not exist in database");
        }

        if (!airportService.existByCityName(flightRequest.cityDep())){
            throw new BadRequestAirportException("The departure city does not have airport");
        }
        if(!airportService.existByCityName(flightRequest.cityArr())){
            throw new BadRequestAirportException("The arrival city does not have airport");
        }
        if(flightRequest.timeTravel()==null){
            return flightRepository.findByRouteDepartureAirportCityNameAndRouteArrivalAirportCityName(
                    flightRequest.cityDep(),
                    flightRequest.cityArr(),
                    pageable
            );
        }
        return flightRepository.findByRouteDepartureAirportCityNameAndRouteArrivalAirportCityNameAndFlightDate(
                flightRequest.cityDep(),
                flightRequest.cityArr(),
                flightRequest.timeTravel(),
                pageable
        );
    }
}
