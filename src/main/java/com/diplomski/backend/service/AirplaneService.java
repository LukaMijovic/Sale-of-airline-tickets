package com.diplomski.backend.service;

import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.exception.NoSuchElementFoundException;

public interface AirplaneService {
    public Airplane findByIataCodeLong(Airplane airplane) throws NoSuchElementFoundException;
}
