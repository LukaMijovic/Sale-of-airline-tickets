package com.diplomski.backend.external.controller_external;

import com.diplomski.backend.external.ResponseExternal;
import com.diplomski.backend.external.dto_external.CityEDTO;
import com.diplomski.backend.external.service_external.CityExternalService;
import com.diplomski.backend.external.mapper_external.CityExternalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/cities")
public class CityExternalController extends ExternalController {
    @Autowired
    private CityExternalService cityExternalService;
    @Override
    public ResponseEntity<Void> saveAllFromExternal() {
        myUriBuilder.setEndpoint("cities");
        myUriBuilder.addParameters("limit",5000);
        String url= myUriBuilder.getUri();
        ResponseExternal response;

        ParameterizedTypeReference<ResponseExternal<CityEDTO>> responseType=new ParameterizedTypeReference<ResponseExternal<CityEDTO>>() {};
        ResponseEntity<ResponseExternal<CityEDTO>> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        response=responseEntity.getBody();
        cityExternalService.saveExternalCall(response,new CityExternalMapper(),"Saving cities ...");

        return ResponseEntity.noContent().build();
    }
}
