package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.*;
import com.diplomski.backend.domain.enumeration.ReservationStatus;
import com.diplomski.backend.domain.enumeration.SeatClass;
import com.diplomski.backend.dto.request.BookingRequest;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.BookingRepository;
import com.diplomski.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private PriceListService priceListService;
    @Autowired
    private SeatStatusService seatStatusService;
    @Autowired
    private TicketService ticketService;

    @Override
    public Booking createBooking(BookingRequest bookingRequest) throws NoSuchElementFoundException {
        Customer customer= customerService.findById(bookingRequest.customerId());
        Flight flight=flightService.findFlightById(bookingRequest.flightId());
        List<Seat> seats=airplaneService.findAllSeats(flight.getAirplane().getId());
        Seat seat=findFirstEmptySeat(bookingRequest.seatClass(),seats);
        System.out.println(seat.getId());

        Booking booking=new Booking();
        booking.setFlight(flight);
        booking.setCustomer(customer);
        booking.setCreationTime(LocalDateTime.now());
        booking.setCurrency("$");
        booking.setStatus(ReservationStatus.REQUESTED);
        Booking bookingSaved=bookingRepository.save(booking);

        SeatStatus seatStatusPom=new SeatStatus();
        seatStatusPom.setSeat(seat);
        seatStatusPom.setFlight(flight);
        SeatStatus seatStatus=seatStatusService.reserveSeat(seatStatusPom);
        PriceList priceList=priceListService.findByFlightId(bookingRequest.flightId());

        Ticket ticket=new Ticket();
        ticket.setCode(String.valueOf(customer.getId()+seat.getCode()+ flight.getId()));
        ticket.setAmount(getPrice(seat.getSeatClass(),priceList));
        ticket.setSeatStatus(seatStatus);
        ticket.setBooking(bookingSaved);

        ticketService.saveTicket(ticket);
        return bookingSaved;
    }

    @Override
    public List<Booking> getBookingsByCustomer(Long id) throws NoSuchElementFoundException {
        Customer customer=customerService.findById(id);
        return customer.getBookings();
    }

    @Override
    public Booking cancelBooking(Long id) throws NoSuchElementFoundException {
        Optional<Booking> optionalBooking =bookingRepository.findById(id);
        if(!optionalBooking.isPresent()){
            throw new NoSuchElementFoundException("The booking with id "+id+" does not exist!");
        }
        Booking booking=optionalBooking.get();
        booking.setStatus(ReservationStatus.CANCELED);
        seatStatusService.cancelReservationSeat(booking.getTickets().get(0).getSeatStatus());
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingRequestByCustomer(Long id) throws NoSuchElementFoundException {
    Customer customer=customerService.findById(id);
//        List<Booking> bookings=customer.getBookings();
//        List<Booking> bookingsRequested=new ArrayList<>();
//        for(Booking booking:bookings){
//            if(booking.getStatus()==ReservationStatus.REQUESTED){
//                bookingsRequested.add(booking);
//            }
//        }
//        return bookingsRequested;
        return bookingRepository.findAllByStatusAndCustomerId(ReservationStatus.REQUESTED,customer.getId());
    }

    @Override
    public List<Booking> getBookingPaidByCustomer(Long id) throws NoSuchElementFoundException {
        Customer customer=customerService.findById(id);
        return bookingRepository.findAllByStatusAndCustomerId(ReservationStatus.CONFIRMED, customer.getId());
    }

    @Override
    public Booking payBooking(Long id) throws NoSuchElementFoundException {
        Optional<Booking> optionalBooking =bookingRepository.findById(id);
        if(!optionalBooking.isPresent()){
            throw new NoSuchElementFoundException("The booking with id "+id+" does not exist!");
        }
        Booking booking=optionalBooking.get();
        if(booking.getStatus()==ReservationStatus.CANCELED){
            throw new NoSuchElementFoundException("You can not pay for canceled booking");
        }
        booking.setStatus(ReservationStatus.CONFIRMED);
        seatStatusService.payReservationSeat(booking.getTickets().get(0).getSeatStatus());
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
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
    private BigDecimal getPrice(SeatClass seatClass,PriceList priceList){
        switch (seatClass){
            case ECONOMY -> {
                return priceList.getEconomyClassPrice();
            }
            case BUSINESS -> {
                return priceList.getBusinessClassPrice();
            }
            case ECONOMY_PLUS -> {
                return priceList.getEconomyPlusClassPrice();
            }
            case PREFERRED_ECONOMY -> {
                return priceList.getPreferredEconomyClassPrice();
            }
            case FIRST_CLASS -> {
                return priceList.getFirstClassPrice();
            }
            default -> throw new NoSuchElementFoundException("Seat class does not exist");
        }
    }
}
