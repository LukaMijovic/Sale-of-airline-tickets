package com.diplomski.backend.external.service_external;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Country;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.external.dto_external.AirlineEDTO;
import com.diplomski.backend.repository.AirlineRepository;
import com.diplomski.backend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AirlineExternalService extends ExternalService<Airline, AirlineEDTO> {
    @Autowired
    private CountryService countryService;
    @Autowired
    private AirlineRepository airlineRepository;
    @Override
    List<Airline> saveObjects(List<Airline> list) {
        return airlineRepository.saveAll(
                list.stream()
                .filter(airline -> airline.getIataCode()!=null)
                .map(airline -> {
                    try{
                        Country country=countryService.findByCodeIso2(airline.getCountry());
                        airline.setCountry(country);
                        return airline;
                    }catch (NoSuchElementFoundException ex){
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
        );
    }
}
