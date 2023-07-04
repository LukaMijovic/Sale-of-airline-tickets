package com.diplomski.backend.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyUriBuilder {
    @Value("${external.api.url}")
    private String baseUrl;
    @Value("${external.api.access-key}")
    private String accessKey;

    private static UriComponentsBuilder uriBuilder;

    public void setEndpoint(String endpoint){
        uriBuilder=UriComponentsBuilder.fromUriString(baseUrl+"/"+endpoint).
                queryParam("access_key",accessKey);
        //.queryParam("limit",100);
    }
    public void addParameters(String key,Object value){
        uriBuilder.queryParam(key,value);
    }
    public  String getUri(){
        return uriBuilder.toUriString();
    }
}
