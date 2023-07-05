package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Route;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.external.dto_external.RouteEDTO;
import com.diplomski.backend.external.service_external.ExternalService;
import com.diplomski.backend.repository.RouteRepository;
import com.diplomski.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteServiceImp implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public Route findByFlightNumber(Route route)throws NoSuchElementFoundException {
        Optional<Route> optionalRoute=routeRepository.findByFlight(route.getFlight());
        if(!optionalRoute.isPresent()){
            throw new NoSuchElementFoundException("The route with number "+route.getFlight()+" does not exist");
        }
        return route;
    }

    @Override
    public boolean existRoute(Route route) throws NoSuchElementFoundException {
        try {
            findByFlightNumber(route);
            return true;
        }catch (NoSuchElementFoundException ex){
            return false;
        }

    }
}
