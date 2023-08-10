package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.Seat;
import com.diplomski.backend.domain.enumeration.SeatClass;
import com.diplomski.backend.dto.request.BookingRequest;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.BookingRepository;
import com.diplomski.backend.service.AirplaneService;
import com.diplomski.backend.service.BookingService;
import com.diplomski.backend.service.CustomerService;
import com.diplomski.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImp implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private AirplaneService airplaneService;

    @Override
    public Booking createBooking(BookingRequest bookingRequest) throws NoSuchElementFoundException {
        Customer customer= customerService.findById(bookingRequest.customerId());
        Flight flight=flightService.findFlightById(bookingRequest.flightId());
        List<Seat> seats=airplaneService.findAllSeats(flight.getAirplane().getId());
        Seat seat=findFirstEmptySeat(bookingRequest.seatClass(),seats);
        return null;
    }
    private Seat findFirstEmptySeat(String seatClassPom,List<Seat> seats) throws NoSuchElementFoundException{
        for(Seat seat:seats){
            SeatClass seatClass=SeatClass.valueOf(seatClassPom);
            if(seat.getOpened() && seatClass==seat.getSeatClass()){
                return seat;
            }
        }
        throw new NoSuchElementFoundException("For this fligth does not exist open seat");
    }
}
