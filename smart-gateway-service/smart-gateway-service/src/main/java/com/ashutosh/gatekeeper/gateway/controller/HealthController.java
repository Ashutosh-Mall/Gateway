package com.ashutosh.gatekeeper.gateway.controller;

import com.ashutosh.gatekeeper.gateway.dto.responseDto.HealthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    private String serviceName;
    private String serviceDescription;

    public HealthController(@Value("${info.app.name}") String name,
                                         @Value("${info.app.description}") String description) {
        this.serviceName = name;
        this.serviceDescription = description;

    }
    @GetMapping
    public ResponseEntity<HealthResponse> health() {
        return ResponseEntity.ok(new HealthResponse(serviceName, serviceDescription, "UP"));
    }

}
