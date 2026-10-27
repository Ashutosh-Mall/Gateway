package com.ashutosh.gatekeeper.management.controller;

import com.ashutosh.gatekeeper.management.dto.responseDto.HealthResponse;
import com.ashutosh.gatekeeper.management.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @GetMapping
    public ResponseEntity<HealthResponse> health() {
        HealthResponse healthResponse = healthService.getHealth();
        return ResponseEntity.ok(healthResponse);
    }
}
