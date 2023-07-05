package com.diplomski.backend.domain;

import com.diplomski.backend.domain.enumeration.ActiveStatus;
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
    public Airline(String name, String iataCode, String icaoCode, String callsign, ActiveStatus activeStatus, Integer fleetSize, Double fleetAvgAge, Integer yearFounded, String image, Country country) {
        this.name = name;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.callsign = callsign;
        this.activeStatus = activeStatus;
        this.fleetSize = fleetSize;
        this.fleetAvgAge = fleetAvgAge;
        this.yearFounded = yearFounded;
        this.image = image;
        this.country = country;
    }

    public Airline(String iataCode) {
        this.iataCode = iataCode;
    }

    public Airline(String name, String iataCode, String icaoCode) {
        this.name = name;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
    }

    public Airline(String iataCode, String icaoCode) {
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
    }

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
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;
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
