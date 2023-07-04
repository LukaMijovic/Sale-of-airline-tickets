package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.FlightRepository;
import com.diplomski.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightServiceImp implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight findByFlightNumber(Flight flight) throws NoSuchElementFoundException {
        Optional<Flight> optionalFlight=flightRepository.findByRouteFlight(flight.getRoute().getFlight());
        if(!optionalFlight.isPresent()){
            throw new NoSuchElementFoundException("Flight with this route does not exist");
        }
        return optionalFlight.get();
    }
}
