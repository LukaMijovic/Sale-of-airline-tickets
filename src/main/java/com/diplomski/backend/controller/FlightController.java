package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.FlightDTO;
import com.diplomski.backend.dto.FlightDTOActive;
import com.diplomski.backend.dto.mapper.FlightActiveMapper;
import com.diplomski.backend.dto.mapper.FlightMapper;
import com.diplomski.backend.dto.request.FlightRequest;
import com.diplomski.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private FlightActiveMapper flightActiveMapper;

    @GetMapping("v1/get-all/{pageNo}")
    public Page<FlightDTO> getFlights(@PathVariable int pageNo){
        return flightMapper.entitiesToDTOs(flightService.getAllFlights(pageNo));
    }
    @GetMapping("v1/get-all/active/{pageNo}")
    public Page<FlightDTOActive> getActiveFlights(@PathVariable int pageNo){
        return flightActiveMapper.entitiesToDTOs(flightService.getActiveFlights(pageNo));
    }
    @GetMapping("v1/get-all/scheduled/{pageNo}")
    public Page<FlightDTOActive> getScheduledFlights(@PathVariable int pageNo){
        return flightActiveMapper.entitiesToDTOs(flightService.getScheduledFlights(pageNo));
    }
    @PostMapping("v1/get/scheduled/{pageNo}")
    public Page<FlightDTOActive> getRequestFlights(@RequestBody FlightRequest flightRequest, @PathVariable int pageNo){
        return flightActiveMapper.entitiesToDTOs(flightService.findActiveFlights(flightRequest,pageNo));
    }
}
