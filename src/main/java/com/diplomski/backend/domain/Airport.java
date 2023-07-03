package com.diplomski.backend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Table(name = "airport")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airport {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @NotEmpty(message = "The name of airport must not be a empty")
    private String name;
    @NotNull
    @Size(min = 3,max = 3,message = "The iata code must have 3 character")
    @Column(name = "iata_code")
    private String iataCode;
    @Size(min = 4,max = 4,message = "Icao code have 4 character")
    @Column(name = "icao_code")
    private String icaoCode;
    private double latitude;
    private double longitude;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
