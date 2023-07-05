package com.diplomski.backend.external.controller_external;

import com.diplomski.backend.external.ResponseExternal;
import com.diplomski.backend.external.dto_external.AirlineEDTO;
import com.diplomski.backend.external.dto_external.AirplaneEDTO;
import com.diplomski.backend.external.dto_external.AirportEDTO;
import com.diplomski.backend.external.mapper_external.AirlineExternalMapper;
import com.diplomski.backend.external.service_external.AirlineExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/airlines")
public class AirlineExternalController extends ExternalController {
    @Autowired
    private AirlineExternalService airlineExternalService;

    @Override
    public ResponseEntity<Void> saveAllFromExternal() {
        myUriBuilder.setEndpoint("airlines");
        myUriBuilder.addParameters("limit",5000);
        String url= myUriBuilder.getUri();
        ResponseExternal response;
        ParameterizedTypeReference<ResponseExternal<AirlineEDTO>> responseType=new ParameterizedTypeReference<ResponseExternal<AirlineEDTO>>() {};
        ResponseEntity<ResponseExternal<AirlineEDTO>> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        response=responseEntity.getBody();
        airlineExternalService.saveExternalCall(response,new AirlineExternalMapper(),"Saving airlines ...");
        return ResponseEntity.noContent().build();
    }
}
