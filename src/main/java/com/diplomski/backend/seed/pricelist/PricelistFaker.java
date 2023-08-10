package com.diplomski.backend.seed.pricelist;

import com.diplomski.backend.domain.PriceList;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

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
        return null;
    }
}
