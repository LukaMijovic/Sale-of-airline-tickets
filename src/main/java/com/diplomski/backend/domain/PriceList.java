package com.diplomski.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "price_list")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceList {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
    @Column(name = "first_class_price")
    private BigDecimal firstClassPrice;
    @Column(name = "business_class_price")
    private BigDecimal businessClassPrice;
    @Column(name = "economy_class_price")
    private BigDecimal economyClassPrice;
    @Column(name = "economy_plus_class_price")
    private BigDecimal economyPlusClassPrice;
    @Column(name = "preferred_economy_class_price")
    private BigDecimal preferredEconomyClassPrice;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
}
