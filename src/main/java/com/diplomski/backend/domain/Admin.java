package com.diplomski.backend.domain;

import com.diplomski.backend.domain.User;
import com.diplomski.backend.domain.enumeration.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "admin")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends User {

    public Admin(@NotEmpty(message = "The username must not be a null value") String username,
                 @Size(min = 5, message = "Password must have more than 5 characters") String password,
                 @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "The email has to be in format xxxx@xxx.com")
                 String email, @Pattern(regexp = "\\+381\\d{9}", message = "Phone number has to be in format +38160...") String phone, Role role,
                 @NonNull String name, @NonNull LocalDate timeEmployment) {
        super(username, password, email, phone,role);
        this.name = name;
        this.timeEmployment = timeEmployment;
    }

    @NonNull
    @NotEmpty
    private String name;
    @NonNull
    @Column(name = "time_employment")
    private LocalDate timeEmployment;

    public void setTimeEmployment(LocalDate timeEmployment) {
        if(timeEmployment.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("The employment time must be before today");
        }
        this.timeEmployment = timeEmployment;
    }
}
