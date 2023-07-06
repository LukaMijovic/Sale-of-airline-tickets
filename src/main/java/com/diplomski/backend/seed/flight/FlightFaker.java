package com.diplomski.backend.seed.flight;

import com.diplomski.backend.domain.Flight;
import com.diplomski.backend.domain.Route;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FlightFaker {
    @Autowired
    private Faker faker;
    @Autowired
    private Random random;

    private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

    public List<Flight> generateFlights(Route route) throws ParseException {
        int numberOfFlights= random.nextInt(7);
        for(int i=0;i<numberOfFlights;i++){
            Flight flight=new Flight();

        }
        return null;
    }
}
