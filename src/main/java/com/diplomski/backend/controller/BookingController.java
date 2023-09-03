package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.dto.BookingAdmin;
import com.diplomski.backend.dto.BookingCustomerDTO;
import com.diplomski.backend.dto.BookingDTO;
import com.diplomski.backend.dto.BookingResponse;
import com.diplomski.backend.dto.mapper.BookingCustomerMapper;
import com.diplomski.backend.dto.mapper.BookingMapper;
import com.diplomski.backend.dto.request.BookingRequest;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:8100")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private BookingCustomerMapper bookingCustomerMapper;

    @PostMapping("/v1/create")
    public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest){

        try{
            Booking booking=bookingService.createBooking(bookingRequest);
            return new BookingResponse(booking.getId(),true);
        }catch (NoSuchElementFoundException ex){
            return new BookingResponse(-1L,false);
        }
    }
    @GetMapping("/v1/get-all/{customerId}")
    public List<BookingDTO> getBookingsByCustomer(@PathVariable Long customerId){
        return bookingMapper.entitiesToDTOs(bookingService.getBookingsByCustomer(customerId));
    }
    @GetMapping("/v2/get-all/{customerId}")
    public List<BookingCustomerDTO> getBookingsDTOByCustomer(@PathVariable Long customerId){
        return bookingCustomerMapper.entitiesToDTOs(bookingService.getBookingsByCustomer(customerId));
    }
    @GetMapping("/v2/get-all/requested/{customerId}")
    public List<BookingCustomerDTO> getBookingsDTORequestedByCustomer(@PathVariable Long customerId){
        return bookingCustomerMapper.entitiesToDTOs(bookingService.getBookingRequestByCustomer(customerId));
    }
    @PutMapping("/v1/cancel/{bookingId}")
    public BookingResponse cancelBooking(@PathVariable Long bookingId){
        try{
            Booking booking=bookingService.cancelBooking(bookingId);
            return new BookingResponse(booking.getId(),true);
        }catch (NoSuchElementFoundException ex){
            return new BookingResponse(-1L,false);
        }
    }
    @PutMapping("/v1/pay/{bookingId}")
    public BookingResponse payBooking(@PathVariable Long bookingId){
        try{
            Booking booking=bookingService.payBooking(bookingId);
            return new BookingResponse(booking.getId(),true);
        }catch (NoSuchElementFoundException ex){
            return new BookingResponse(-1L,false);
        }
    }
    @GetMapping("/v1/get-all/paid/{customerId}")
    public List<BookingCustomerDTO> getBookingPaidByCustomer(@PathVariable Long customerId){
        return bookingCustomerMapper.entitiesToDTOs(bookingService.getBookingPaidByCustomer(customerId));
    }
    @GetMapping("/v1/admin/get-all")
    public List<BookingAdmin> getAllBookings(){
        return null;
    }
}
