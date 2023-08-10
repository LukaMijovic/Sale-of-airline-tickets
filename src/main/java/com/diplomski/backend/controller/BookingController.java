package com.diplomski.backend.controller;

import com.diplomski.backend.dto.BookingDTO;
import com.diplomski.backend.dto.request.BookingRequest;
import com.diplomski.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:8100")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/v1/create")
    public BookingDTO createBooking(@RequestBody BookingRequest bookingRequest){
        return null;
    }
}
