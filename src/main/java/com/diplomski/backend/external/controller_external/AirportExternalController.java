package com.diplomski.backend.external.controller_external;

import com.diplomski.backend.external.ResponseExternal;
import com.diplomski.backend.external.dto_external.AirportEDTO;
import com.diplomski.backend.external.dto_external.CountryEDTO;
import com.diplomski.backend.external.mapper_external.AirportExternalMapper;
import com.diplomski.backend.external.service_external.AirportExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/airports")
public class AirportExternalController extends ExternalController {
    @Autowired
    private AirportExternalService airportExternalService;

    @Override
    public ResponseEntity<Void> saveAllFromExternal() {
        myUriBuilder.setEndpoint("airports");
        myUriBuilder.addParameters("limit",6000);
        String url= myUriBuilder.getUri();
        ResponseExternal response;
        ParameterizedTypeReference<ResponseExternal<AirportEDTO>> responseType=new ParameterizedTypeReference<ResponseExternal<AirportEDTO>>() {};
        ResponseEntity<ResponseExternal<AirportEDTO>> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        response=responseEntity.getBody();
        airportExternalService.saveExternalCall(response,new AirportExternalMapper(),"Saving airports ...");

        return ResponseEntity.noContent().build();

    }
}
