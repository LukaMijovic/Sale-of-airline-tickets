package com.diplomski.backend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {

    public Country(@NonNull String name, @NonNull String iso2Code, String iso3Code, Integer population, String capital, String continent, String currencyName, String currencyCode, String phonePrefix) {
        this.name = name;
        this.iso2Code = iso2Code;
        this.iso3Code = iso3Code;
        this.population = population;
        this.capital = capital;
        this.continent = continent;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.phonePrefix = phonePrefix;
    }

    public Country(@NonNull String name, @NonNull String iso2Code) {
        this.name = name;
        this.iso2Code = iso2Code;
    }

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @NotEmpty(message = "The name of country must not be a null value")
    private String name;
    @NonNull
    @NotEmpty(message = "The iso2 code of country must not be a null value")
    @Column(name = "code_iso2")
    @Size(min = 2,max = 2)
    private String iso2Code;
    @Size(min = 3,max = 3)
    @Column(name = "code_iso3")
    private String iso3Code;
    private Integer population;
    private String capital;
    private String continent;
    @Column(name = "currency_name")
    private String currencyName;
    @Column(name="currency_code")
    private String currencyCode;
    @Column(name = "phone_prefix")
    private String phonePrefix;
    @OneToMany(mappedBy = "country")
    private Set<City> cities;
    @OneToMany(mappedBy = "country")
    private Set<Airport> airports;
    @OneToMany(mappedBy = "country")
    private Set<Airline> airlines;
}
