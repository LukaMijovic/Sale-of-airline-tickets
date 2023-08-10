package com.diplomski.backend.service;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.dto.request.BookingRequest;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface BookingService {
    public Booking createBooking(BookingRequest bookingRequest) throws NoSuchElementFoundException;
}
