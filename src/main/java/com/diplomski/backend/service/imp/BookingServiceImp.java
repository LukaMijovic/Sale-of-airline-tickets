package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.repository.BookingRepository;
import com.diplomski.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImp implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public Booking createBooking(Booking booking) {
        return null;
    }
}
