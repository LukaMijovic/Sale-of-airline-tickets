package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.dto.FlightDTO;
import com.diplomski.backend.dto.FlightDTOActive;
import com.diplomski.backend.dto.FlightDTOActive2;
import com.diplomski.backend.dto.mapper.FlightActive2Mapper;
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
    @Autowired
    private FlightActive2Mapper flightActive2Mapper;

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
        Page<FlightDTOActive> flights = flightActiveMapper.entitiesToDTOs(flightService.findActiveFlights(flightRequest,pageNo));
        System.out.println(flights.get().count());
        return flights;
    }
    @PostMapping("v2/get/scheduled/{pageNo}")
    public Page<FlightDTOActive2> getRequestFlights2(@RequestBody FlightRequest flightRequest, @PathVariable int pageNo){
        return flightActive2Mapper.entitiesToDTOs(flightService.findActiveFlights(flightRequest,pageNo));
    }
    @GetMapping("v1/get/{id}/scheduled")
    public FlightDTOActive2 getFlightById(@PathVariable Long id){
        return flightActive2Mapper.entityToDTO(flightService.findFlightById(id));
    }
}
