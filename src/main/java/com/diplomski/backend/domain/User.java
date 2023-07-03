package com.diplomski.backend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@Data
@Table(name = "airport_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    @NotEmpty(message = "The username must not be a null value")
    private String username;

    @Size(min = 5,message = "Password must have more than 5 characters")
    private String password;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "The email has to be in format xxxx@xxx.com")
    private String email;
    @Pattern(regexp = "\\+381\\d{9}",message = "Phone number has to be in format +38160...")
    private String phone;

}
