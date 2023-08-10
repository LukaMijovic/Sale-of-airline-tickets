package com.diplomski.backend.service;

import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.exception.BadRequestAirportException;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface CustomerService {
    public Customer registration(Customer customer);
    public Customer login(Customer customer) throws BadRequestAirportException;
    public Customer findById(Long id) throws NoSuchElementFoundException;
}
