package com.diplomski.backend.seed.flight;

import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.Route;
import com.diplomski.backend.domain.enumeration.FlightStatus;
import com.diplomski.backend.utility.MyDateFormatterMapper;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FlightFaker {
    private Faker faker;
    private FakeValuesService fakeValuesService;

    private Random random;

    public FlightFaker() {
        random=new Random();
        faker=new Faker(Locale.ENGLISH,random);
        fakeValuesService=new FakeValuesService(Locale.ENGLISH,new RandomService());
    }

    private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

    public List<Flight> generateFlights(Route route,Airplane airplane) throws ParseException {
        int numberOfFlights= random.nextInt(7);
        List<Flight> flights=new ArrayList<>();
        for(int i=0;i<numberOfFlights;i++){
            Flight flight=new Flight();
            flight.setRoute(route);
            flight.setAirplane(airplane);
            flight.setFlightDate(generateDate());
            flight.setFlightStatus(generateFlightStatus(flight.getFlightDate()));
            if(route.getDepartureTerminal()!=null)
                flight.setDepGate(fakeValuesService.regexify("[A-Z][1-9][0-9]?|100"));
            if(route.getArrivalTerminal()!=null)
                flight.setArrGate(fakeValuesService.regexify("[A-Z][1-9][0-9]?|100"));
            if(flight.getFlightStatus()==FlightStatus.ARRIVED){
                flight.setDepDelay(0);
                flight.setArrDelay(0);
            }
            flight.setDepScheduled(LocalDateTime.of(flight.getFlightDate(),route.getDepartureTime()));
            flight.setDepEstimated(LocalDateTime.of(flight.getFlightDate(),route.getDepartureTime()));

            flight.setArrScheduled(LocalDateTime.of(flight.getFlightDate(),route.getArrivalTime()));
            flight.setArrEstimated(LocalDateTime.of(flight.getFlightDate(),route.getArrivalTime()));
            if(flight.getFlightStatus()==FlightStatus.ARRIVED){
                flight.setDepEstimated(LocalDateTime.of(flight.getFlightDate(),route.getDepartureTime()));
            }
            if(flight.getFlightStatus()==FlightStatus.ARRIVED){
              flight.setArrScheduled(LocalDateTime.of(flight.getFlightDate(),route.getArrivalTime()));
              flight.setArrEstimated(LocalDateTime.of(flight.getFlightDate(),route.getArrivalTime()));
              flight.setArrActual(LocalDateTime.of(flight.getFlightDate(),route.getArrivalTime()));
              flight.setBaggage(fakeValuesService.regexify("[A-Z]{2}"));
              flight.setUpdatedFlight(flight.getArrActual());
            }
            flights.add(flight);
        }
        return flights;
    }

    private FlightStatus generateFlightStatus(LocalDate date) {
        if(date.isBefore(LocalDate.now())){
            return FlightStatus.ARRIVED;
        }else{
            return FlightStatus.SCHEDULED;
        }
    }

    private LocalDate generateDate() throws ParseException {
        return MyDateFormatterMapper.convertToLocalDateViaInstant(
                faker.date().between(format.parse("2023-01-01"),format.parse("2024-12-12"))
        );
    }

    public Airplane getRandomAirplane(List<Airplane> airplanes){
        if(airplanes==null || airplanes.size()==0){
            return null;
        }
        //random=new Random();
        return airplanes.get(random.nextInt(airplanes.size()));
    }
}
