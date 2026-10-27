package com.ashutosh.gatekeeper.management.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class HealthResponse {
    private String serviceName;
    private String serviceDescription;
    private String dbStatus;
    private LocalDateTime timestamp;
}
