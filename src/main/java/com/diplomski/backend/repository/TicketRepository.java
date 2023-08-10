package com.diplomski.backend.repository;

import com.diplomski.backend.domain.Ticket;
import com.diplomski.backend.dto.TicketDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, TicketDTO> {
}
