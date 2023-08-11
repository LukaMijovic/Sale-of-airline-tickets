package com.diplomski.backend.service;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.dto.request.BookingRequest;
import com.diplomski.backend.exception.NoSuchElementFoundException;

import java.util.List;

public interface BookingService {
    public Booking createBooking(BookingRequest bookingRequest) throws NoSuchElementFoundException;
    public List<Booking> getBookingsByCustomer(Long id) throws NoSuchElementFoundException;
    public Booking cancelBooking(Long id) throws NoSuchElementFoundException;
}
