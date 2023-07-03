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
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "The flight has to a non null value")
    private Integer flight;
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
