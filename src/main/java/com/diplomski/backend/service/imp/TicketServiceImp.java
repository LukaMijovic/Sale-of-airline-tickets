package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Ticket;
import com.diplomski.backend.repository.TicketRepository;
import com.diplomski.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImp implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
