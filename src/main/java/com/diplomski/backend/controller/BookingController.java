package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.dto.BookingDTO;
import com.diplomski.backend.dto.BookingResponse;
import com.diplomski.backend.dto.mapper.BookingMapper;
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
    @Autowired
    private BookingMapper bookingMapper;

    @PostMapping("/v1/create")
    public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest){
        Booking booking=bookingService.createBooking(bookingRequest);
        return new BookingResponse(booking.getId(),true);
    }
}
