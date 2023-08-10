package com.diplomski.backend;

import com.diplomski.backend.repository.FlightRepository;
import com.diplomski.backend.seed.MyFakerServis;
import com.diplomski.backend.utility.FlightRegulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BackendApplication {

	@Autowired
	private MyFakerServis myFakerServis;
	@Autowired
	private FlightRegulator flightRegulator;
	@Value("${myapp.seed.flight}")
	private boolean flightSeed;
	@Value("${myapp.seed.seat}")
	private boolean seatSeed;
	@Value("${myapp.seed.priceList}")
	private boolean priceListSeed;
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void setUpFlight(){
		if(flightSeed)
			myFakerServis.initFlights();
		if(seatSeed){
			//System.out.println(1);
			myFakerServis.initSeats();
		}
		if(priceListSeed)
			myFakerServis.initPriceList();
		flightRegulator.regulate();
	}
}
