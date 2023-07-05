package com.diplomski.backend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@Table(name = "route")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {

    public Route(Integer flight,String iataFlight,String icaoFlight, Airport departureAirport, String departureTerminal, LocalTime departureTime, Airport arrivalAirport, String arrivalTerminal, LocalTime arrivalTime, Airline airline, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.flight = flight;
        this.iataFlight=iataFlight;
        this.icaoFlight=icaoFlight;
        this.departureAirport = departureAirport;
        this.departureTerminal = departureTerminal;
        this.departureTime = departureTime;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTerminal = arrivalTerminal;
        this.arrivalTime = arrivalTime;
        this.airline = airline;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Route(Integer flight) {
        this.flight = flight;
    }

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "The flight has to a non null value")
    private Integer flight;
    @NotNull(message = "The flight iata code has to a non null values")
    @Column(name = "flight_iata")
    private String iataFlight;
    @NotNull(message = "The flight icao code has to a non null values")
    @Column(name = "flight_icao")
    private String icaoFlight;
    @ManyToOne
    @JoinColumn(name = "dep_airport_id")
    private Airport departureAirport;
    @Column(name = "dep_terminal")
    private String departureTerminal;
    @Column(name = "dep_time")
    private LocalTime departureTime;
    @ManyToOne
    @JoinColumn(name = "arr_airport_id")
    private Airport arrivalAirport;
    @Column(name = "arr_terminal")
    private String arrivalTerminal;
    @Column(name = "arr_time")
    private LocalTime arrivalTime;
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "update_date")
    private LocalDateTime updatedDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "route")
    private Set<Flight> flights;

}
