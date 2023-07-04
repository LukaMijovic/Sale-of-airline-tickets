package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.AirportRepository;
import com.diplomski.backend.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportServiceImp implements AirportService {
    @Autowired
    private AirportRepository airportRepository;
    @Override
    public Airport findByIataCode(Airport airport) throws NoSuchElementFoundException {
        Optional<Airport> optionalAirport=airportRepository.findByIataCode(airport.getIataCode());
        if(!optionalAirport.isPresent()){
            throw new NoSuchElementFoundException("The airport with iata code "+airport.getIataCode()+" does not exist");
        }
        return optionalAirport.get();
    }
}
