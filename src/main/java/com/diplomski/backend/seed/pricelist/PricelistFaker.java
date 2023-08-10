package com.diplomski.backend.seed.pricelist;

import com.diplomski.backend.domain.PriceList;
import com.diplomski.backend.domain.Route;
import com.diplomski.backend.domain.enumeration.SeatClass;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class PricelistFaker {
    private Faker faker;
    private FakeValuesService fakeValuesService;

    private Random random;
    public PricelistFaker(){
        random=new Random();
        faker=new Faker(Locale.ENGLISH,random);
        fakeValuesService=new FakeValuesService(Locale.ENGLISH,new RandomService());
    }
    public List<PriceList> init(){
        List<PriceList> priceLists=new ArrayList<>();
        for(Long i = 1L; i<=25; i++){
           PriceList priceList=new PriceList();
           Route route=new Route();
           route.setId(i);
           priceList.setRoute(route);
           priceList.setEconomyClassPrice(generateTicketPrice(SeatClass.ECONOMY));
           priceList.setEconomyPlusClassPrice(generateTicketPrice(SeatClass.ECONOMY_PLUS));
           priceList.setPreferredEconomyClassPrice(generateTicketPrice(SeatClass.PREFERRED_ECONOMY));
           priceList.setBusinessClassPrice(generateTicketPrice(SeatClass.BUSINESS));
           priceList.setFirstClassPrice(generateTicketPrice(SeatClass.FIRST_CLASS));
           priceList.setStartDate(LocalDate.now());
           priceList.setEndDate(LocalDate.of(2030,12,31));
           priceLists.add(priceList);
        }
        return priceLists;
    }
    private BigDecimal generateTicketPrice(SeatClass seatClass){
        BigDecimal basePrice= BigDecimal.valueOf(100);
        BigDecimal priceRange=BigDecimal.valueOf(50);
        switch (seatClass){
            case ECONOMY -> {
                return basePrice.add(priceRange.multiply(new BigDecimal(random.nextDouble())));
            }
            case ECONOMY_PLUS -> {
                return basePrice.add(priceRange).add(priceRange.multiply(new BigDecimal(String.valueOf(random.nextDouble()))));
            }
            case PREFERRED_ECONOMY -> {
                return basePrice.add(priceRange.multiply(new BigDecimal("2"))).add(priceRange.multiply(new BigDecimal(String.valueOf(random.nextDouble()))));
            }
            case BUSINESS -> {
                return basePrice.add(priceRange.multiply(new BigDecimal("3"))).add(priceRange.multiply(new BigDecimal(String.valueOf(new Random().nextDouble()))));
            }
            case FIRST_CLASS -> {
                return basePrice.add(priceRange.multiply(new BigDecimal("4"))).add(priceRange.multiply(new BigDecimal(String.valueOf(new Random().nextDouble()))));
            }
            default -> throw new IllegalArgumentException("Unknown ticket class: ");
        }
    }
}
