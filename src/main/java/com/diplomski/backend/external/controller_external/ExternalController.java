package com.diplomski.backend.external.controller_external;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExternalController {
    ResponseEntity<Void> saveAllFromExternal();
}
