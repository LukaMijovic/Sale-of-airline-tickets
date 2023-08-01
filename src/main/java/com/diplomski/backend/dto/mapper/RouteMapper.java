package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Route;
import com.diplomski.backend.dto.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RouteMapper implements Mapper<Route, RouteDTO> {
    @Autowired
    private AirportMapper airportMapper;
    @Autowired
    private AirlineMapper airlineMapper;
    @Override
    public RouteDTO entityToDTO(Route entity) {
        return new RouteDTO(entity.getId(),
                entity.getFlight(),
                entity.getIataFlight(),
                entity.getIcaoFlight(),
                airportMapper.entityToDTO(entity.getDepartureAirport()),
                entity.getDepartureTerminal(),
                entity.getDepartureTime(),
                airportMapper.entityToDTO(entity.getArrivalAirport()),
                entity.getArrivalTerminal(),
                entity.getArrivalTime(),
                airlineMapper.entityToDTO(entity.getAirline()),
                entity.getCreatedDate(),
                entity.getUpdatedDate());
    }

    @Override
    public Route DTOtoEntity(RouteDTO routeDTO) {
        return null;
    }
}
