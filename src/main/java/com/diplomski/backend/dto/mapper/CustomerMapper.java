package com.diplomski.backend.dto.mapper;

import com.diplomski.backend.domain.Customer;
import com.diplomski.backend.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements Mapper<Customer, CustomerDTO> {
    @Override
    public CustomerDTO entityToDTO(Customer entity) {
        return new CustomerDTO(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getPhone(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthDate(),
                entity.getCity(),
                entity.getCounty(),
                entity.getAccountStatus(),
                entity.getRegistrationTime(),
                entity.getLastEditTime()
        );
    }

    @Override
    public Customer DTOtoEntity(CustomerDTO customerDTO) {
        return null;
    }
}
