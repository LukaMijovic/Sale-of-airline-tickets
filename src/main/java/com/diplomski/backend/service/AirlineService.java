package com.diplomski.backend.service;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AirlineService {
    public Airline findByIataCode(Airline airline) throws NoSuchElementFoundException;
    public boolean existIataCodeAndIcaoCode(Airline airline);
    public Airline findByIataCodeAndIcaoCode(Airline airline) throws NoSuchElementFoundException;
    public List<Airplane> findAllAirplaneByAirline(Airline airline) throws NoSuchElementFoundException;

    List<Airline> getAll();

    Airline findById(Long airlineId) throws NoSuchElementFoundException;
}
