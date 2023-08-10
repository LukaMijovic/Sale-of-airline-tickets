package com.diplomski.backend.service.imp;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.PriceList;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.repository.PriceListRepository;
import com.diplomski.backend.service.FlightService;
import com.diplomski.backend.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceListServiceImp implements PriceListService {
    @Autowired
    private PriceListRepository priceListRepository;
    @Autowired
    private FlightService flightService;
    @Override
    public PriceList findByFlightId(Long id) throws NoSuchElementFoundException {
        Flight flight=flightService.findFlightById(id);
        Optional<PriceList> optionalPriceList=priceListRepository.findByRouteId(flight.getRoute().getId());
        if(!optionalPriceList.isPresent()){
            throw new NoSuchElementFoundException("PriceList for route with id "+flight.getRoute().getId()+" does not exist");
        }
        return optionalPriceList.get();
    }
}
