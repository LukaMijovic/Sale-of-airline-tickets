package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.AirlineRepository;
import com.diplomski.backend.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineServiceImp implements AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;
    @Override
    public Airline findByIataCode(Airline airline) throws NoSuchElementFoundException {
        Optional<Airline> optionalAirline=airlineRepository.findByIataCode(airline.getIataCode());
        if(!optionalAirline.isPresent()){
            throw  new NoSuchElementFoundException("Airline with iata code "+airline.getIataCode()+" does not exist");
        }
        return optionalAirline.get();
    }
}
