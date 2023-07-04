package com.diplomski.backend.service;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface AirlineService {
    public Airline findByIataCode(Airline airline) throws NoSuchElementFoundException;
}
