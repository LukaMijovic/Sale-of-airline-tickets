package com.diplomski.backend.domain;

import com.diplomski.backend.domain.enumeration.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    private ReservationStatus status;
    private String currency;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "booking")
    private List<Ticket> tickets;
}
