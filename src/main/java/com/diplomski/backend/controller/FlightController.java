package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.FlightDTO;
import com.diplomski.backend.dto.mapper.FlightMapper;
import com.diplomski.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightMapper flightMapper;

    @GetMapping("v1/get-all/{pageNo}")
    public Page<FlightDTO> getFlights(@PathVariable int pageNo){
        return flightMapper.entitiesToDTOs(flightService.getAllFlights(pageNo));
    }
    @GetMapping("v1/get-all/active/{pageNo}")
    public Page<FlightDTO> getActiveFlights(@PathVariable int pageNo){
        return flightMapper.entitiesToDTOs(flightService.getActiveFlights(pageNo));
    }
    @GetMapping("v1/get-all/scheduled/{pageNo}")
    public Page<FlightDTO> getScheduledFlights(@PathVariable int pageNo){
        return flightMapper.entitiesToDTOs(flightService.getScheduledFlights(pageNo));
    }
}
