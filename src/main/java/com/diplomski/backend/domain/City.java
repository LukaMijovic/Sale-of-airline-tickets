package com.diplomski.backend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
    public City(String name, String iataCode, double latitude, double longitude, String timezone, Country country) {
        this.name = name;
        this.iataCode = iataCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.country = country;
    }

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @NotEmpty(message = "The name of city must not be a null value")
    private String name;
    @Column(name = "iata_code")
    @NotNull
    @Size(min =3,max = 3,message = "Iata code must have 3 character")
    private String iataCode;
    private double latitude;
    private double longitude;
    private String timezone;
    @ManyToOne
    @JoinColumn(name = "country_id",nullable = true)
    private Country country;
    @OneToMany(mappedBy = "city")
    private Set<Airport> airports;
}
