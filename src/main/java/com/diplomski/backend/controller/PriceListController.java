package com.diplomski.backend.controller;

import com.diplomski.backend.dto.PriceListDTO;
import com.diplomski.backend.dto.mapper.PriceListMapper;
import com.diplomski.backend.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricelist/")
@CrossOrigin(origins = "http://localhost:8100")
public class PriceListController {
    @Autowired
    private PriceListService priceListService;
    @Autowired
    private PriceListMapper priceListMapper;

    @GetMapping("/v1/flight/{id}")
    public PriceListDTO getPriceListByFlightId(@PathVariable Long id){
        return priceListMapper.entityToDTO(priceListService.findByFlightId(id));
    }
}
