package com.diplomski.backend.external.controller_external;

import com.diplomski.backend.external.ResponseExternal;
import com.diplomski.backend.external.dto_external.CountryEDTO;
import com.diplomski.backend.external.service_external.CountryExternalService;
import com.diplomski.backend.external.mapper_external.CountryExternalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/countries")
public class CountryExternalController extends ExternalController{

    @Autowired
    private CountryExternalService countryExternalService;
    @Override
    public ResponseEntity<Void> saveAllFromExternal() {
        myUriBuilder.setEndpoint("countries");
        myUriBuilder.addParameters("limit",500);
        String url=myUriBuilder.getUri();
        ResponseExternal response;

        ParameterizedTypeReference<ResponseExternal<CountryEDTO>> responseType=new ParameterizedTypeReference<ResponseExternal<CountryEDTO>>() {};
        ResponseEntity<ResponseExternal<CountryEDTO>> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        response=responseEntity.getBody();
        countryExternalService.saveExternalCall(response,new CountryExternalMapper(),"Saving countries...");
        return ResponseEntity.noContent().build();
    }
}
