package com.diplomski.backend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "airline")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airline {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Name must be a non null value")
    private String name;
    @NotNull(message ="Iata code must be a non null value")
    @Size(min = 2,max = 2,message = "Iata code have 2 characters")
    private String iataCode;
    @Size(min = 3,max = 3,message = "Icao code have 2 characters")
    private String icaoCode;
    private String callsign;
    private Integer fleetSize;
    private Double fleetAvgAge;
    private Integer yearFounded;
    private String image;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(mappedBy = "airline")
    private Set<Airplane> airplanes;
    @OneToMany(mappedBy = "airline")
    private Set<Route> routes;
}
