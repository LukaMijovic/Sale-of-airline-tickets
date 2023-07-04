package com.diplomski.backend.service;

import com.diplomski.backend.domain.Country;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface CountryService {
    public Country findByCodeIso2(Country country) throws NoSuchElementFoundException;
}
