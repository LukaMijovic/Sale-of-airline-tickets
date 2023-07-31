package com.diplomski.backend.service;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.exception.NoSuchElementFoundException;

import java.util.List;

public interface AirplaneService {
    public Airplane findByIataCodeLong(Airplane airplane) throws NoSuchElementFoundException;

    List<Airplane> findAllByAirline(Airline airline);
    List<Airplane> findAll();
}
