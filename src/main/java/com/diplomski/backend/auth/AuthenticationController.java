package com.diplomski.backend.auth;

import com.diplomski.backend.dto.CustomerDTO;
import com.diplomski.backend.dto.mapper.CustomerMapper;
import com.diplomski.backend.dto.request.CustomerRegistration;
import com.diplomski.backend.exception.BadRequestCustomerException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;
    @Autowired
    private CustomerMapper customerMapper;


    @PostMapping("/v1/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
    @PostMapping("/v1/login")
    public ResponseEntity<Object> login(
            @RequestBody AuthRequest request
    ){
        try{
            return ResponseEntity.ok(service.login(request));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
        }

    }
    @PostMapping("/v1/registration")
    public ResponseEntity<Object> registration(@RequestBody CustomerRegistration customerRegistration){
        try{
            return ResponseEntity.ok(customerMapper.entityToDTO(service.registration(customerRegistration)));
        }catch (BadRequestCustomerException ex){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
        }

    }

}
