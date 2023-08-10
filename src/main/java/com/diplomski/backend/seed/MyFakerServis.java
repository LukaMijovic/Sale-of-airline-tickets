package com.diplomski.backend.seed;

import com.diplomski.backend.domain.*;
import com.diplomski.backend.repository.FlightRepository;
import com.diplomski.backend.repository.PriceListRepository;
import com.diplomski.backend.repository.SeatRepository;
import com.diplomski.backend.seed.flight.FlightFaker;
import com.diplomski.backend.seed.pricelist.PricelistFaker;
import com.diplomski.backend.seed.seat.SeatFaker;
import com.diplomski.backend.service.AirlineService;
import com.diplomski.backend.service.AirplaneService;
import com.diplomski.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class MyFakerServis {
    private FlightFaker flightFaker;
    private SeatFaker seatFaker;
    private PricelistFaker pricelistFaker;
    @Autowired
    private RouteService routeService;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirplaneService airplaneService;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private PriceListRepository priceListRepository;

    public void initFlights(){
        List<Route> routes=routeService.findAll().stream().toList();
        for(Route route: routes){
            flightFaker=new FlightFaker();
            Airplane airplane=flightFaker.getRandomAirplane(airplaneService.findAllByAirline(route.getAirline()));
            if(airplane==null){
                continue;
            }
            System.out.println(airplane.getId());
            try {
                List<Flight> flights=flightFaker.generateFlights(route,airplane);
                flightRepository.saveAll(flights);
            } catch (ParseException e) {
                System.out.println("Excepton: "+e.getMessage());
            }
        }
    }
    public void initSeats(){
        List<Airplane> airplanes=airplaneService.findAll();
        for(Airplane airplane:airplanes){
            seatFaker=new SeatFaker();
            //System.out.println(11);
            List<Seat> seats=seatFaker.generateSeats(airplane);
           // System.out.println(1);
            seatRepository.saveAll(seats);
        }
    }
    public void initPriceList(){
        pricelistFaker=new PricelistFaker();
        List<PriceList> priceLists=pricelistFaker.init();
        priceListRepository.saveAll(priceLists);
    }
}
