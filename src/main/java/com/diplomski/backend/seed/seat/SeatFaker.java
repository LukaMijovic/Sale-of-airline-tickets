package com.diplomski.backend.seed.seat;

import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.domain.Seat;
import com.diplomski.backend.domain.enumeration.SeatClass;
import com.diplomski.backend.domain.enumeration.SeatType;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.*;

public class SeatFaker {
    private Faker faker;
    private FakeValuesService fakeValuesService;
    private Random random;
    private List<String> codes=new ArrayList<>();
    private List<String> cabins=new ArrayList<>();

    public SeatFaker(){
        random=new Random();
        faker=new Faker(Locale.ENGLISH,random);
        fakeValuesService=new FakeValuesService(Locale.ENGLISH,new RandomService());
    }
   private void generateCodes(){
        for(int i=1;i<=360;i++){
            String code;
            do {
                code=faker.regexify("[A-Z]{3}");
            }while(codes.contains(code));
            codes.add(code);
        }
   }
   private void generateCabins(){
        char c='A';
        int k=1;
        for(int i=1;i<=360;i++){
            if(i%20==0){
                c++;
            }
            if(k%6==0){
                k=1;
            }
            String cabin=k+String.valueOf(c);
            cabins.add(cabin);
        }
   }

    public List<Seat> generateSeats(Airplane airplane){
        List<Seat> seats=new ArrayList<>();
        generateCodes();
        generateCabins();
        for(int i=1;i<=150;i++){
            Seat seat=new Seat();
            seat.setSeatClass(SeatClass.ECONOMY);
            seat.setAirplane(airplane);
            seat.setSeatType(SeatType.REGULAR);
            seat.setOpened(true);
            seat.setCode(codes.get(i-1));
            seat.setCabin(cabins.get(i-1));
            seats.add(seat);
        }

        for(int i=151;i<=250;i++){
            Seat seat=new Seat();
            seat.setSeatClass(SeatClass.ECONOMY_PLUS);
            seat.setAirplane(airplane);
            seat.setSeatType(SeatType.REGULAR);
            seat.setOpened(true);
            seat.setCode(codes.get(i-1));
            seat.setCabin(cabins.get(i-1));
            seats.add(seat);
        }
        for(int i=251;i<=300;i++){
            Seat seat=new Seat();
            seat.setSeatClass(SeatClass.PREFERRED_ECONOMY);
            seat.setAirplane(airplane);
            seat.setSeatType(SeatType.REGULAR);
            seat.setOpened(true);
            seat.setCode(codes.get(i-1));
            seat.setCabin(cabins.get(i-1));
            seats.add(seat);
        }
        for(int i=301;i<=335;i++){
            Seat seat=new Seat();
            seat.setSeatClass(SeatClass.BUSINESS);
            seat.setAirplane(airplane);
            seat.setSeatType(SeatType.REGULAR);
            seat.setOpened(true);
            seat.setCode(codes.get(i-1));
            seat.setCabin(cabins.get(i-1));
            seats.add(seat);
        }
        for(int i=336;i<=360;i++){
            Seat seat=new Seat();
            seat.setSeatClass(SeatClass.FIRST_CLASS);
            seat.setAirplane(airplane);
            seat.setSeatType(SeatType.REGULAR);
            seat.setOpened(true);
            seat.setCode(codes.get(i-1));
            seat.setCabin(cabins.get(i-1));
            seats.add(seat);
        }
        return seats;
    }


}
