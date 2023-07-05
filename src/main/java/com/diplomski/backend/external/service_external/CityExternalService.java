package com.diplomski.backend.external.service_external;

import com.diplomski.backend.domain.City;
import com.diplomski.backend.domain.Country;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.external.dto_external.CityEDTO;
import com.diplomski.backend.repository.CityRepository;
import com.diplomski.backend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityExternalService extends ExternalService<City, CityEDTO> {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryService countryService;
    @Override
    List<City> saveObjects(List<City> list) {
        List<City> newList=new ArrayList<>();
        for(City city:list){
            if(city.getIataCode()==null){
                continue;
            }try {
                Country country=countryService.findByCodeIso2(city.getCountry());
                city.setCountry(country);
                newList.add(city);
            }catch (NoSuchElementFoundException ex){
                //System.out.println(ex.getMessage());
            }

        }
        return cityRepository.saveAll(newList).stream().toList();
    }

    @Override
    protected CityEDTO trimList(CityEDTO cityEDTO) {
        if(cityEDTO.getCountryIso2()==null){
            return null;
        }
        return cityEDTO;
    }
}
