package com.diplomski.backend.service;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.request.FlightRequest;
import com.diplomski.backend.exception.BadRequestAirportException;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FlightService {
    public Flight findByFlightNumber(Flight flight) throws NoSuchElementFoundException;
    public Page<Flight> getAllFlights(int pageNo);
    public Page<Flight> getActiveFlights(int pageNo);

    public Page<Flight> getScheduledFlights(int pageNo);
    public Page<Flight> findActiveFlights(FlightRequest flightRequest,int pageNo) throws BadRequestAirportException;
}
