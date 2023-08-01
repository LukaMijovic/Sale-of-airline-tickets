package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Flight;
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

    @GetMapping("v1/get-all/{pageNo}")
    public Page<Flight> getFlights(@PathVariable int pageNo){
        return flightService.getAllFlights(pageNo);
    }
}
