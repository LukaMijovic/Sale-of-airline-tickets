package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Route;
import com.diplomski.backend.dto.BookingResponse;
import com.diplomski.backend.dto.request.RouteRequest;
import com.diplomski.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @PostMapping("/v1/create")
    public BookingResponse createRoute(@RequestBody RouteRequest routeRequest){
        try{
            Route route=routeService.createRoute(routeRequest);
            return new BookingResponse(route.getId(),true);
        }catch (Exception ex){
            ex.printStackTrace();
            return new BookingResponse(-1L,false);
        }
    }
}
