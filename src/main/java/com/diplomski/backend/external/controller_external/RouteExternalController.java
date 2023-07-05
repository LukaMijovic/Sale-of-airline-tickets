package com.diplomski.backend.external.controller_external;

import com.diplomski.backend.external.ResponseExternal;
import com.diplomski.backend.external.dto_external.AirportEDTO;
import com.diplomski.backend.external.dto_external.RouteEDTO;
import com.diplomski.backend.external.mapper_external.RouteExternalMapper;
import com.diplomski.backend.external.service_external.RouteExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/routes")
public class RouteExternalController extends ExternalController{
    @Autowired
    private RouteExternalService routeExternalService;

    @Override
    public ResponseEntity<Void> saveAllFromExternal() {
        myUriBuilder.setEndpoint("flights");
        myUriBuilder.addParameters("limit",15000);
        String url= myUriBuilder.getUri();
        ResponseExternal response;
        ParameterizedTypeReference<ResponseExternal<RouteEDTO>> responseType=new ParameterizedTypeReference<ResponseExternal<RouteEDTO>>() {};
        ResponseEntity<ResponseExternal<RouteEDTO>> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        response=responseEntity.getBody();
        routeExternalService.saveExternalCall(response,new RouteExternalMapper(),"Saving routes...");
        return ResponseEntity.noContent().build();
    }
}
