package com.diplomski.backend.service;

import com.diplomski.backend.domain.Route;
import com.diplomski.backend.dto.request.RouteRequest;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import org.springframework.data.domain.Page;

public interface RouteService {
    public Route findByFlightNumber(Route route) throws NoSuchElementFoundException;
    public boolean existRoute(Route route) throws NoSuchElementFoundException;
    public Page<Route> findAll();
    public Route createRoute(RouteRequest routeRequest) throws NoSuchElementFoundException;
}
