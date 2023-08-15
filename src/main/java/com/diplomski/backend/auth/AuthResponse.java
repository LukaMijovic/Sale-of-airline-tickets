package com.diplomski.backend.auth;

import com.diplomski.backend.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private CustomerDTO customerDTO;
    private String token;
}
