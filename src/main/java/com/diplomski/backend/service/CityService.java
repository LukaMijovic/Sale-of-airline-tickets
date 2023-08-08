package com.diplomski.backend.service;

import com.diplomski.backend.domain.City;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface CityService {
    public City findByIataCode(City city) throws NoSuchElementFoundException;
    public City findByName(String name) throws NoSuchElementFoundException;
}
