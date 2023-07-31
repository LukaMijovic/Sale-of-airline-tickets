package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.AirplaneRepository;
import com.diplomski.backend.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImp implements AirplaneService {
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Override
    public Airplane findByIataCodeLong(Airplane airplane) throws NoSuchElementFoundException {
        Optional<Airplane> optionalAirplane=airplaneRepository.findByIataCodeLong(airplane.getIataCodeLong());
        if(!optionalAirplane.isPresent()){
            throw new NoSuchElementFoundException("The airplane with iata code long "+airplane.getIataCodeLong()+" does not exist");
        }
        return optionalAirplane.get();
    }

    @Override
    public List<Airplane> findAllByAirline(Airline airline) {
       return airplaneRepository.findAllByAirlineId(airline.getId());
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }
}
