package com.diplomski.backend.service;

import com.diplomski.backend.domain.PriceList;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface PriceListService {
    public PriceList findByFlightId(Long id) throws NoSuchElementFoundException;
}
