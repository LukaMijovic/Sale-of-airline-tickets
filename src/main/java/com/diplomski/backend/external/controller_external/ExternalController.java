package com.diplomski.backend.external.controller_external;

import com.diplomski.backend.external.MyUriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public abstract class ExternalController {
    @Autowired
    protected RestTemplate restTemplate;
    @Autowired
    protected MyUriBuilder myUriBuilder;
    @GetMapping

    public abstract ResponseEntity<Void> saveAllFromExternal();
}
