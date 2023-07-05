package com.diplomski.backend.service;

import com.diplomski.backend.domain.Route;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface RouteService {
    public Route findByFlightNumber(Route route) throws NoSuchElementFoundException;
    public boolean existRoute(Route route) throws NoSuchElementFoundException;
}
