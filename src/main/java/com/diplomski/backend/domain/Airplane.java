package com.diplomski.backend.domain;

import com.diplomski.backend.domain.enumeration.ActiveStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "airplane")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airplane {
    public Airplane(String iataCodeLong) {
        this.iataCodeLong = iataCodeLong;
    }

    public Airplane(String iataCodeLong, String icaoCodeHex, String registrationNumber) {
        this.iataCodeLong = iataCodeLong;
        this.icaoCodeHex = icaoCodeHex;
        this.registrationNumber = registrationNumber;
    }

    public Airplane(String iataType, String iataCodeLong, String iataCodeShort, ActiveStatus activeStatus, String constructionNumber, LocalDateTime deliveryDate, LocalDateTime firstFlightDate, Integer engineCount, String engineType, String icaoCodeHex, Integer age, String planeOwner, String registrationNumber, LocalDateTime registrationDate, Airline airline) {
        this.iataType = iataType;
        this.iataCodeLong = iataCodeLong;
        this.iataCodeShort = iataCodeShort;
        this.activeStatus = activeStatus;
        this.constructionNumber = constructionNumber;
        this.deliveryDate = deliveryDate;
        this.firstFlightDate = firstFlightDate;
        this.engineCount = engineCount;
        this.engineType = engineType;
        this.icaoCodeHex = icaoCodeHex;
        this.age = age;
        this.planeOwner = planeOwner;
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.airline = airline;
    }

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
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;
    @Column(name = "construction_number")
    private String constructionNumber;
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
    @OneToMany(mappedBy = "airplane")
    private Set<Flight>  flights;
    @OneToMany(mappedBy = "airplane")
    private List<Seat> seats;

}
