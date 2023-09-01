package com.diplomski.backend.auth;

import com.diplomski.backend.domain.User;
import com.diplomski.backend.domain.enumeration.Role;
import com.diplomski.backend.dto.CustomerDTO;
import com.diplomski.backend.dto.mapper.CustomerMapper;
import com.diplomski.backend.dto.request.CustomerRegistration;
import com.diplomski.backend.dto.request.ValidateRequest;
import com.diplomski.backend.email.EmailService;
import com.diplomski.backend.exception.BadRequestCustomerException;
import com.diplomski.backend.repository.UserRepository;
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
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;


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
    @PostMapping("/v1/validate")
    public ResponseEntity<Object> validateRegistration(@RequestBody ValidateRequest validateRequest){
        if(userRepository.existsByEmail(validateRequest.email())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already taken");
        }
        User user=new User();
        user.setEmail(validateRequest.email());
        user.setRole(Role.CUSTOMER);

        //userRepository.save(user);

        String subject="Air Sales Application | Customer Account Notification";
        String email= validateRequest.email();
        String link="link";
        String message="Hi "+validateRequest.firstName()+", \nYour Customer Account setup \n"+
                "LINK FOR REGISTRATION: "+link;
        emailService.sendRegisterEmail(email,subject,message);
        return ResponseEntity.ok(validateRequest);
    }

}
