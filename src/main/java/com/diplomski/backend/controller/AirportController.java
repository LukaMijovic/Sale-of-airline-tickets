package com.diplomski.backend.controller;

import com.diplomski.backend.dto.AirportDTO;
import com.diplomski.backend.dto.mapper.AirportMapper;
import com.diplomski.backend.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping("/v1/get-by-city/{city}")
    public ResponseEntity<Object> getAirportsByCity(@PathVariable String city){
        try {
            return ResponseEntity.ok(airportMapper.entitiesToDTOs(airportService.getByCity(city)));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping("/v2/get-by-city/{city}")
    public ResponseEntity<Object> getAirportSByCityStep(@PathVariable String city){
        try{
            return ResponseEntity.ok(airportMapper.entitiesToDTOs(airportService.getByCityStep(city)));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
