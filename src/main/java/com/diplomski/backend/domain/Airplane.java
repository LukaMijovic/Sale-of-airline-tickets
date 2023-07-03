package com.diplomski.backend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "airplane")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airplane {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "iata_type")
    private String iataType;
    @Column(name = "iata_code_long")
    @NotNull(message = "The iata code long must not be a null value")
    @Size(min=4,max=4,message = "The iata code long has 4 characters")
    private String iataCodeLong;
    @NotNull(message = "The iata code short must not be a null value")
    @Size(min=4,max=4,message = "The iata code short has 3 characters")
    @Column(name = "iata_code_short")
    private String iataCodeShort;
    @Column(name = "construction_number")
    private Integer constructionNumber;
    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;
    @Column(name = "first_flight_date")
    private LocalDateTime firstFlightDate;
    @Column(name = "engine_count")
    private Integer engineCount;
    @Column(name = "engine_type")
    private String engineType;
    @NotNull
    @Size(min = 6,max = 6,message = "The icao code hex must have 4 characters")
    @Column(name = "icao_code_hex")
    private String icaoCodeHex;
    private Integer age;
    @Column(name = "plane_owner")
    private String planeOwner;
    @NotNull
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

}
