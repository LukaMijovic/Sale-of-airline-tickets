package com.diplomski.backend.external.service_external;

import com.diplomski.backend.domain.Airport;
import com.diplomski.backend.domain.City;
import com.diplomski.backend.domain.Country;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.external.dto_external.AirportEDTO;
import com.diplomski.backend.repository.AirportRepository;
import com.diplomski.backend.service.CityService;
import com.diplomski.backend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportExternalService extends ExternalService<Airport, AirportEDTO> {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @Override
    List<Airport> saveObjects(List<Airport> list) {
        List<Airport> newList=new ArrayList<>();
        for(Airport airport:list){
            if(airport.getIataCode()==null){
                continue;
            }
            try {
                City city=cityService.findByIataCode(airport.getCity());
                Country country=countryService.findByCodeIso2(airport.getCountry());
                airport.setCity(city);
                airport.setCountry(country);
                newList.add(airport);
            }catch (NoSuchElementFoundException ex){

            }
        }
        return airportRepository.saveAll(newList).stream().toList();
    }
}
