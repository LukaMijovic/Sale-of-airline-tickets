package com.diplomski.backend.domain;

import com.diplomski.backend.domain.enumeration.SeatClass;
import com.diplomski.backend.domain.enumeration.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "seat")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String cabin;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
}
