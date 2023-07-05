package com.diplomski.backend.external.service_external;

import com.diplomski.backend.domain.Country;
import com.diplomski.backend.external.dto_external.CountryEDTO;
import com.diplomski.backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryExternalService extends ExternalService<Country, CountryEDTO> {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    List<Country> saveObjects(List<Country> list) {
        List<Country> newList=list.stream().filter(country ->
                 country.getIso2Code()!=null && !country.getIso2Code().equals(""))
                .toList();
        return countryRepository.saveAll(newList).stream().toList();
    }

    @Override
    protected CountryEDTO trimList(CountryEDTO countryEDTO) {
        return countryEDTO;
    }
}
