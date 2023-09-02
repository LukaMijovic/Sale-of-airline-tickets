package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.dto.AirlineDTO;
import com.diplomski.backend.dto.mapper.AirlineMapper;
import com.diplomski.backend.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/airline")
public class AirlineController {
    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirlineMapper airlineMapper;

    @GetMapping("/v1/get-all")
    public List<AirlineDTO> getAllAirlines(){
        return airlineMapper.entitiesToDTOs(airlineService.getAll());
    }
}
