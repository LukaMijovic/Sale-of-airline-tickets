package com.diplomski.backend.external.controller_external;

import com.diplomski.backend.external.ResponseExternal;
import com.diplomski.backend.external.dto_external.AirplaneEDTO;
import com.diplomski.backend.external.dto_external.AirportEDTO;
import com.diplomski.backend.external.mapper_external.AirplaneExternalMapper;
import com.diplomski.backend.external.service_external.AirplaneExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/airplanes")
public class AirplaneExternalController extends ExternalController {
    @Autowired
    private AirplaneExternalService airplaneExternalService;

    @Override
    public ResponseEntity<Void> saveAllFromExternal() {
        myUriBuilder.setEndpoint("airplanes");
        myUriBuilder.addParameters("limit",19000);
        String url= myUriBuilder.getUri();
        ResponseExternal response;
        ParameterizedTypeReference<ResponseExternal<AirplaneEDTO>> responseType=new ParameterizedTypeReference<ResponseExternal<AirplaneEDTO>>() {};
        ResponseEntity<ResponseExternal<AirplaneEDTO>> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        response=responseEntity.getBody();
        airplaneExternalService.saveExternalCall(response,new AirplaneExternalMapper(),"Saving airplanes ...");
        return ResponseEntity.noContent().build();
    }
}
