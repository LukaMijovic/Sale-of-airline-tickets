package com.diplomski.backend.controller;

import com.diplomski.backend.dto.SeatDTO;
import com.diplomski.backend.dto.mapper.SeatMapper;
import com.diplomski.backend.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/airplane")
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;
    @Autowired
    private SeatMapper seatMapper;
    @GetMapping("/v1/get-seats/{id}")
    public List<SeatDTO> getAllSeats(@PathVariable Long id){
        return seatMapper.entitiesToDTOs(airplaneService.findAllSeats(id));
    }
}
