package com.diplomski.backend.controller;

import com.diplomski.backend.dto.AirportDTO;
import com.diplomski.backend.dto.mapper.AirportMapper;
import com.diplomski.backend.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;
    @Autowired
    private AirportMapper airportMapper;
    @GetMapping("/v1/get-all/{pageNo}")
    public Page<AirportDTO> getAllAirports(@PathVariable int pageNo){
        return airportMapper.entitiesToDTOs(airportService.getAll(pageNo));
    }
}
