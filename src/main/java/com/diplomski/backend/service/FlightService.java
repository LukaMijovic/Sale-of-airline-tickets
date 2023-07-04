package com.diplomski.backend.service;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface FlightService {
    public Flight findByFlightNumber(Flight flight) throws NoSuchElementFoundException;
}
