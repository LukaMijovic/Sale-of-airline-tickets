package com.diplomski.backend.seed;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.Random;

@Configuration
public class MyFakerConfiguration {
    @Bean
    public Faker faker(){
        return new Faker(Locale.ENGLISH,new Random());
    }
}
