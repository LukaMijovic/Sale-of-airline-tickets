package com.diplomski.backend.domain;

import com.diplomski.backend.domain.enumeration.SeatStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "seat_status")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatStatus {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status_state")
    private SeatStatusEnum seatStatus;
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
}
