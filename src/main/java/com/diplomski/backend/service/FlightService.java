package com.diplomski.backend.service;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import org.springframework.data.domain.Page;

public interface FlightService {
    public Flight findByFlightNumber(Flight flight) throws NoSuchElementFoundException;
    public Page<Flight> getAllFlights(int pageNo);
}
