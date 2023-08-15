package com.diplomski.backend.auth;

import com.diplomski.backend.config.JwtService;
import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.domain.User;
import com.diplomski.backend.dto.request.CustomerRegistration;
import com.diplomski.backend.repository.UserRepository;
import com.diplomski.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtService jwtService;

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        System.out.println(user.getEmail());
        String jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthResponse login (AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public Customer registration(CustomerRegistration customerRegistration) {
        Customer customer=new Customer();
        customer.setUsername(customerRegistration.username());
        customer.setEmail(customerRegistration.email());
        customer.setPassword(customerRegistration.password());
        customer.setPhone(customerRegistration.phone());
        customer.setFirstName(customerRegistration.firstName());
        customer.setLastName(customerRegistration.lastName());
        customer.setBirthDate(customerRegistration.birthDate());
        customer.setCity(customerRegistration.city());
        customer.setCounty(customerRegistration.country());
        return customerService.registration(customer);
    }
}
