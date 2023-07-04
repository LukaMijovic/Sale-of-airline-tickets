package com.diplomski.backend.service;

import com.diplomski.backend.domain.Country;

public interface CountryService {
    public Country findByCodeIso2(Country country);
}
