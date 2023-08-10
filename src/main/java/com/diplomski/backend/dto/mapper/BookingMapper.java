package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.dto.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper implements Mapper<Booking, BookingDTO> {
    @Autowired
    private TicketMapper ticketMapper;
    @Override
    public BookingDTO entityToDTO(Booking entity) {
        return new BookingDTO(
                entity.getId(),
                entity.getCreationTime(),
                entity.getEndTime(),
                entity.getCurrency(),
                entity.getStatus(),
                entity.getCustomer().getId(),
                entity.getFlight().getId(),
                ticketMapper.entitiesToDTOs(entity.getTickets())
        );
    }

    @Override
    public Booking DTOtoEntity(BookingDTO bookingDTO) {
        return null;
    }
}
