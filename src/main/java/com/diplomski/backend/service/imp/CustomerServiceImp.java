package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.domain.enumeration.AccountStatus;
import com.diplomski.backend.domain.enumeration.Role;
import com.diplomski.backend.repository.CustomerRepository;
import com.diplomski.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer registration(Customer customer) {
        customer.setAccountStatus(AccountStatus.ACTIVE);
        customer.setRole(Role.CUSTOMER);
        customer.setRegistrationTime(LocalDateTime.now());
        return customerRepository.save(customer);
    }
}
