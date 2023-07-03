package com.diplomski.backend.domain;

import com.diplomski.backend.domain.enumeration.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "customer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    public Customer(String username, String password, String email, String phone, String firstName,
                    String lastName, LocalDate birthDate, String city, String county) {
        super(username, password, email, phone);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.city = city;
        this.county = county;
        this.accountStatus=AccountStatus.ACTIVE;
        this.registrationTime=LocalDateTime.now();
    }

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String city;
    private  String county;
    @Enumerated(EnumType.STRING)
    @Column(name = "acc_status")
    private AccountStatus accountStatus;
    @Column(name = "registration_time")
    private LocalDateTime registrationTime;
    @Column(name = "last_edit_time")
    private LocalDateTime lastEditTime;
    @Transient
    private LocalDateTime loginTime;
    @Transient
    private LocalDateTime logoutTime;

}
