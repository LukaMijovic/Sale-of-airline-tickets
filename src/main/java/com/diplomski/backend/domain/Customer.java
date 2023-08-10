package com.diplomski.backend.domain;

import com.diplomski.backend.domain.enumeration.AccountStatus;
import com.diplomski.backend.domain.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends User {

    public Customer(String username, String password, String email, String phone, Role role, String firstName,
                    String lastName, LocalDate birthDate, String city, String county) {
        super(username, password, email, phone,role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.city = city;
        this.county = county;
        this.accountStatus=AccountStatus.ACTIVE;
        this.registrationTime=LocalDateTime.now();
    }

    @Column(name = "first_name")
    @NonNull
    @NotEmpty(message = "The first name must not be a empty value")
    private String firstName;
    @NonNull
    @NotEmpty(message = "The last name must not be a empty value")
    @Column(name = "last_name")
    private String lastName;
    @NonNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @NonNull
    private String city;
    @NonNull
    private  String county;
    @Enumerated(EnumType.STRING)
    @Column(name = "acc_status")
    private AccountStatus accountStatus;
    @NonNull
    @Column(name = "registration_time")
    private LocalDateTime registrationTime;
    @Column(name = "last_edit_time")
    private LocalDateTime lastEditTime;
    @Transient
    private LocalDateTime loginTime;
    @Transient
    private LocalDateTime logoutTime;
    @OneToMany(mappedBy = "customer")
    List<Booking> bookings;

}
