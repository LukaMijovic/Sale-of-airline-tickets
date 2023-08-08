package com.diplomski.backend.service;

import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.exception.BadRequestAirportException;

public interface CustomerService {
    public Customer registration(Customer customer);
    public Customer login(Customer customer) throws BadRequestAirportException;
}
