package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.dto.BookingCustomerDTO;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class BookingCustomerMapper implements Mapper<Booking, BookingCustomerDTO> {
    @Override
    public BookingCustomerDTO entityToDTO(Booking entity) {
        return new BookingCustomerDTO(
                entity.getFlight().getFlightDate(),
                entity.getFlight().getDepScheduled().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
                entity.getFlight().getArrScheduled().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
                entity.getFlight().getRoute().getAirline().getName(),
                entity.getFlight().getRoute().getDepartureAirport().getIataCode(),
                entity.getFlight().getRoute().getArrivalAirport().getIataCode(),
                entity.getTickets().get(0).getSeatStatus().getSeat().getCode(),
                entity.getTickets().get(0).getSeatStatus().getSeat().getSeatClass().toString(),
                entity.getTickets().get(0).getAmount().doubleValue()
        );
    }

    @Override
    public Booking DTOtoEntity(BookingCustomerDTO bookingCustomerDTO) {
        return null;
    }
}
