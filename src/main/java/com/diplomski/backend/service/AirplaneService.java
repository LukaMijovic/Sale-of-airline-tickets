package com.diplomski.backend.service;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.Seat;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Set;

public interface AirplaneService {
    public Airplane findByIataCodeLong(Airplane airplane) throws NoSuchElementFoundException;

    List<Airplane> findAllByAirline(Airline airline);
    List<Airplane> findAll();
    List<Seat> findAllSeats(Long id) throws EntityNotFoundException;
    List<Seat> findAllOpenedSeats(Long id) throws EntityNotFoundException;
}
