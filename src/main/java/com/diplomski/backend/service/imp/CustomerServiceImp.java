package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.domain.enumeration.AccountStatus;
import com.diplomski.backend.domain.enumeration.Role;
import com.diplomski.backend.exception.BadRequestAirportException;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.CustomerRepository;
import com.diplomski.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @Override
    public Customer login(Customer customer) throws BadRequestAirportException {
        Optional<Customer> optionalCustomer=customerRepository.findByEmailAndPassword(customer.getEmail(),customer.getPassword());
        if(!optionalCustomer.isPresent()){
            throw new BadRequestAirportException("Email or password is not correct");
        }
        return optionalCustomer.get();
    }

    @Override
    public Customer findById(Long id) throws NoSuchElementFoundException {
        Optional<Customer> optionalCustomer=customerRepository.findById(id);
        if(!optionalCustomer.isPresent()){
            throw new NoSuchElementFoundException("Customer with id "+id+" does not exist!");
        }
        return optionalCustomer.get();
    }
}
