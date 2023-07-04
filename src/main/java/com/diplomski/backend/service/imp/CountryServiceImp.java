package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Country;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.CountryRepository;
import com.diplomski.backend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImp implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Country findByCodeIso2(Country country) throws NoSuchElementFoundException {
        Optional<Country> optional=countryRepository.findByIso2Code(country.getIso2Code());
        if(!optional.isPresent()){
            throw new NoSuchElementFoundException("Country with iso code "+country.getIso2Code()+" doesnt exist!");
        }
        return optional.get();
    }
}
