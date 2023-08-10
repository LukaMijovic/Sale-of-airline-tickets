package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Ticket;
import com.diplomski.backend.dto.TicketDTO;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper implements Mapper<Ticket, TicketDTO> {
    @Override
    public TicketDTO entityToDTO(Ticket entity) {
        return new TicketDTO(
                entity.getId(),
                entity.getCode(),
                entity.getAmount()
        );
    }

    @Override
    public Ticket DTOtoEntity(TicketDTO ticketDTO) {
        return null;
    }
}
