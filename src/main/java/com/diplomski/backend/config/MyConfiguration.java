package com.diplomski.backend.config;

import com.diplomski.backend.external.MyUriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public MyUriBuilder myUriBuilder(){
        return new MyUriBuilder();
    }


}
