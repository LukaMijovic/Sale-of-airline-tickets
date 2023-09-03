package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.enumeration.ActiveStatus;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.AirlineRepository;
import com.diplomski.backend.service.AirlineService;
import jakarta.transaction.NotSupportedException;
import jdk.jshell.spi.ExecutionControl;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImp implements AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;
    @Override
    public Airline findByIataCode(Airline airline) throws NoSuchElementFoundException {
        //Optional<Airline> optionalAirline=airlineRepository.findByIataCode(airline.getIataCode());
        System.out.println(airline.getIataCode()+","+airline.getIcaoCode());
        Optional<Airline> optionalAirline=airlineRepository.findByIataCodeAndIcaoCodeAndActiveStatus(airline.getIataCode(),airline.getIcaoCode(), ActiveStatus.ACTIVE);
        if(!optionalAirline.isPresent()){
            throw  new NoSuchElementFoundException("Airline with iata code "+airline.getIataCode()+" does not exist");
        }
        return optionalAirline.get();
    }

    @Override
    public boolean existIataCodeAndIcaoCode(Airline airline){
        return airlineRepository.existsByIataCodeAndIcaoCode(airline.getIataCode(), airline.getIcaoCode());
    }

    @Override
    public Airline findByIataCodeAndIcaoCode(Airline airline) throws NoSuchElementFoundException {
        //System.out.println(airline.getIataCode()+","+airline.getIcaoCode());
        Optional<Airline> optionalAirline=airlineRepository.findByIataCodeAndIcaoCode(airline.getIataCode(),airline.getIcaoCode());
        if(!optionalAirline.isPresent()){
            throw  new NoSuchElementFoundException("Airline with iata code "+airline.getIataCode()+" does not exist");
        }
        return optionalAirline.get();
    }

    @Override
    public List<Airplane> findAllAirplaneByAirline(Airline airline) throws NoSuchElementFoundException {
        throw new NotImplementedException("Not yet implemented...");
    }

    @Override
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline findById(Long airlineId) throws NoSuchElementFoundException {
        Optional<Airline> optionalAirline=airlineRepository.findById(airlineId);
        if(!optionalAirline.isPresent()){
            throw new NoSuchElementFoundException("The airline with id "+airlineId+" does not exist!");
        }
        return optionalAirline.get();
    }
}
