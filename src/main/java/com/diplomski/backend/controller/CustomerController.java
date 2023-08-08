package com.diplomski.backend.controller;

import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.dto.CustomerDTO;
import com.diplomski.backend.dto.mapper.CustomerMapper;
import com.diplomski.backend.dto.request.CustomerLogin;
import com.diplomski.backend.dto.request.CustomerRegistration;
import com.diplomski.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;
    @PostMapping("/v1/registration")
    public CustomerDTO registration(@RequestBody CustomerRegistration customerRegistration){
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
        return customerMapper.entityToDTO(customerService.registration(customer));
    }
    @PostMapping("/v1/login")
    public CustomerDTO login(@RequestBody CustomerLogin customerLogin){
        Customer customer=new Customer();
        customer.setEmail(customerLogin.email());
        customer.setPassword(customerLogin.password());
        return customerMapper.entityToDTO(customerService.login(customer));
    }
}
