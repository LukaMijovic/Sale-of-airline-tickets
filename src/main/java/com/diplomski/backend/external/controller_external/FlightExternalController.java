package com.diplomski.backend.external.controller_external;

import com.diplomski.backend.external.ResponseExternal;
import com.diplomski.backend.external.dto_external.FlightEDTO;
import com.diplomski.backend.external.dto_external.RouteEDTO;
import com.diplomski.backend.external.mapper_external.FlightExternalMapper;
import com.diplomski.backend.external.service_external.FlightExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/flights")
public class FlightExternalController extends ExternalController{
    @Autowired
    private FlightExternalService flightExternalService;

    @Override
    public ResponseEntity<Void> saveAllFromExternal() {
        myUriBuilder.setEndpoint("flights");
        myUriBuilder.addParameters("limit",15000);
        String url= myUriBuilder.getUri();
        ResponseExternal response;
        ParameterizedTypeReference<ResponseExternal<FlightEDTO>> responseType=new ParameterizedTypeReference<ResponseExternal<FlightEDTO>>() {};
        ResponseEntity<ResponseExternal<FlightEDTO>> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        response=responseEntity.getBody();

        flightExternalService.saveExternalCall(response,new FlightExternalMapper(),"Saving flights ...");
        return ResponseEntity.noContent().build();
    }
}
