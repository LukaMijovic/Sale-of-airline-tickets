package com.diplomski.backend.service;

import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface AirportService {
    public Airport findByIataCode(Airport airport) throws NoSuchElementFoundException;
}
