package com.diplomski.backend.utility;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.enumeration.FlightStatus;
import com.diplomski.backend.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FlightRegulator {
    @Autowired
    private FlightRepository flightRepository;
    public void regulate(){
        List<Flight> flights=flightRepository.findAll();
        for(Flight flight:flights){
            if(flight.getArrScheduled().isBefore(LocalDateTime.now())){
                flight.setArrActual(flight.getArrScheduled());
                flight.setUpdatedFlight(LocalDateTime.now());
                flight.setFlightStatus(FlightStatus.ARRIVED);
            }
        }
    }
}
