package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.domain.City;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.AirportRepository;
import com.diplomski.backend.repository.CityRepository;
import com.diplomski.backend.service.AirportService;
import com.diplomski.backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImp implements AirportService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityService cityService;
    @Override
    public Airport findByIataCode(Airport airport) throws NoSuchElementFoundException {
        Optional<Airport> optionalAirport=airportRepository.findByIataCode(airport.getIataCode());
        if(!optionalAirport.isPresent()){
            throw new NoSuchElementFoundException("The airport with iata code "+airport.getIataCode()+" does not exist");
        }
        return optionalAirport.get();
    }

    @Override
    public Page<Airport> getAll(int pageNo) {
        Pageable pageable= PageRequest.of(pageNo,10);
        return airportRepository.findAll(pageable);
    }

    @Override
    public boolean existByCityName(String name) {
        return airportRepository.existsByCityName(name);
    }

    @Override
    public List<Airport> getByCity(String cityName) throws Exception {
        City city=cityService.findByName(cityName);
        return airportRepository.findByCity(city);
    }

    @Override
    public Page<Airport> getByCityStep(String city) {
        Pageable pageable=PageRequest.of(0,10);
        return airportRepository.findByCityNameIgnoreCaseStartingWith(pageable,city);
    }
}
