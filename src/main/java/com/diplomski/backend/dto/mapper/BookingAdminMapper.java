package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Booking;
import com.diplomski.backend.dto.BookingAdmin;
import org.springframework.stereotype.Component;

@Component
public class BookingAdminMapper implements Mapper<Booking, BookingAdmin> {
    @Override
    public BookingAdmin entityToDTO(Booking entity) {
        return new BookingAdmin(
                entity.getId(),
                entity.getStatus().toString(),
                entity.getCustomer().getId(),
                entity.getFlight().getId()
        );
    }

    @Override
    public Booking DTOtoEntity(BookingAdmin bookingAdmin) {
        return null;
    }
}
