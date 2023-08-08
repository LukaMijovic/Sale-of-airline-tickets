package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.City;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.CityRepository;
import com.diplomski.backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImp implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public City findByIataCode(City city) throws NoSuchElementFoundException {
        Optional<City> optionalCity=cityRepository.findByIataCode(city.getIataCode());
        if(!optionalCity.isPresent()){
            throw new NoSuchElementFoundException("City with iata code "+city.getIataCode()+" doesnt exist");
        }
        return optionalCity.get();
    }

    @Override
    public City findByName(String name) throws NoSuchElementFoundException {
        Optional<City> optionalCity=cityRepository.findByName(name);
        if(!optionalCity.isPresent()){
            throw new NoSuchElementFoundException("City with name "+name+" does not exist");
        }
        return optionalCity.get();
    }
}
