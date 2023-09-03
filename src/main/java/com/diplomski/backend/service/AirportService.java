package com.diplomski.backend.service;

import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AirportService {
    public Airport findByIataCode(Airport airport) throws NoSuchElementFoundException;
    public Page<Airport> getAll(int pageNo);
    public boolean existByCityName(String name);

    List<Airport> getByCity(String city) throws Exception;

    Page<Airport> getByCityStep(String city);
}
