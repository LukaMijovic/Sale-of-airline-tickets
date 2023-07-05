package com.diplomski.backend.domain;

import com.diplomski.backend.domain.enumeration.FlightStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    public Flight(LocalDate flightDate, FlightStatus flightStatus, String depGate, Integer depDelay, LocalDateTime depScheduled, LocalDateTime depEstimated, LocalDateTime depActual, String arrGate, Integer arrDelay, LocalDateTime arrScheduled, LocalDateTime arrEstimated, LocalDateTime arrActual, String baggage, LocalDateTime updatedFlight, Airplane airplane, Route route) {
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.depGate = depGate;
        this.depDelay = depDelay;
        this.depScheduled = depScheduled;
        this.depEstimated = depEstimated;
        this.depActual = depActual;
        this.arrGate = arrGate;
        this.arrDelay = arrDelay;
        this.arrScheduled = arrScheduled;
        this.arrEstimated = arrEstimated;
        this.arrActual = arrActual;
        this.baggage = baggage;
        this.updatedFlight = updatedFlight;
        this.airplane = airplane;
        this.route = route;
        this.createdFlight=LocalDateTime.now();
    }

    public Flight(LocalDate flightDate, FlightStatus flightStatus, String depGate, Integer depDelay, LocalDateTime depScheduled, LocalDateTime depEstimated, LocalDateTime depActual, String arrGate, Integer arrDelay, LocalDateTime arrScheduled, LocalDateTime arrEstimated, LocalDateTime arrActual, String baggage, LocalDateTime createdFlight, LocalDateTime updatedFlight, Airplane airplane, Route route) {
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.depGate = depGate;
        this.depDelay = depDelay;
        this.depScheduled = depScheduled;
        this.depEstimated = depEstimated;
        this.depActual = depActual;
        this.arrGate = arrGate;
        this.arrDelay = arrDelay;
        this.arrScheduled = arrScheduled;
        this.arrEstimated = arrEstimated;
        this.arrActual = arrActual;
        this.baggage = baggage;
        this.createdFlight = createdFlight;
        this.updatedFlight = updatedFlight;
        this.airplane = airplane;
        this.route = route;
    }

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate flightDate;
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;
    @Column(name = "dep_gate")
    private String depGate;
    @Column(name="dep_delay")
    private Integer depDelay;
    @Column(name = "dep_scheduled")
    private LocalDateTime depScheduled;
    @Column(name = "dep_estimated")
    private LocalDateTime depEstimated;
    @Column(name = "dep_actual")
    private LocalDateTime depActual;
    @Column(name = "arr_gate")
    private String arrGate;
    @Column(name="arr_delay")
    private Integer arrDelay;
    @Column(name = "arr_scheduled")
    private LocalDateTime arrScheduled;
    @Column(name = "arr_estimated")
    private LocalDateTime arrEstimated;
    @Column(name = "arr_actual")
    private LocalDateTime arrActual;
    private String baggage;
    @Column(name = "created_flight")
    private LocalDateTime createdFlight;
    @Column(name = "updated_flight")
    private LocalDateTime updatedFlight;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
