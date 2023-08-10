package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.Seat;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.AirplaneRepository;
import com.diplomski.backend.service.AirplaneService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public List<Seat> findAllSeats(Long id) throws EntityNotFoundException {
        Optional<Airplane> optionalAirplane=airplaneRepository.findById(id);
        if(!optionalAirplane.isPresent()){
            throw new EntityNotFoundException("Airplane with this id does not exist");
        }
        return optionalAirplane.get().getSeats();
    }

    @Override
    public List<Seat> findAllOpenedSeats(Long id) throws EntityNotFoundException {
        return null;
    }
}
