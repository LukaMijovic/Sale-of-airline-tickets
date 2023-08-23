package com.diplomski.backend.auth;

import com.diplomski.backend.config.JwtService;
import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.domain.User;
import com.diplomski.backend.dto.mapper.CustomerMapper;
import com.diplomski.backend.dto.request.CustomerRegistration;
import com.diplomski.backend.exception.BadRequestCustomerException;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.UserRepository;
import com.diplomski.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;
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
    public AuthResponse login (AuthRequest request) throws NoSuchElementFoundException {
        //User user = userRepository.findByEmail(request.getEmail())
         //       .orElseThrow();
        Optional<User> optionalUser=userRepository.findByEmailAndPassword(request.getEmail(),request.getPassword());
        if(!optionalUser.isPresent()){
            throw new NoSuchElementFoundException("Email or password is not correct!");
        }
        User user=optionalUser.get();
        Customer customer=customerService.findById(user.getId());
        String jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .customerDTO(customerMapper.entityToDTO(customer))
                .token(jwtToken)
                .build();
    }

    public Customer registration(CustomerRegistration customerRegistration) throws BadRequestCustomerException {
        Optional<User> optionalUser=userRepository.findByEmail(customerRegistration.email());
        if(optionalUser.isPresent()){
            throw new BadRequestCustomerException("There is a user with this email!");
        }
        Customer customer=new Customer();
        customer.setUsername(customerRegistration.username());
        customer.setEmail(customerRegistration.email());
        customer.setPassword(customerRegistration.password());
        customer.setPhone(customerRegistration.phone());
        customer.setFirstName(customerRegistration.firstName());
        customer.setLastName(customerRegistration.lastName());
        if(customerRegistration.birthDate()!=null){
            customer.setBirthDate(LocalDate.parse(customerRegistration.birthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }else{
            customer.setBirthDate(null);
        }

        customer.setCity(customerRegistration.city());
        customer.setCounty(customerRegistration.country());
        return customerService.registration(customer);
    }
}
