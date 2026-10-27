package com.ashutosh.gatekeeper.management.service;

import com.ashutosh.gatekeeper.management.dto.responseDto.HealthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class HealthService {

    private JdbcTemplate jdbcTemplate;
    private String serviceName;
    private String serviceDescription;

    public HealthService(JdbcTemplate jdbcTemplate,
                         @Value("${info.app.name}") String name,
                         @Value("${info.app.description}") String description) {
        this.jdbcTemplate = jdbcTemplate;
        this.serviceName = name;
        this.serviceDescription = description;

    }

    public HealthResponse  getHealth(){
        String databaseStatus = "DOWN";
        try {

            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);

            if(Integer.valueOf(1).equals(result)) {
                databaseStatus = "UP";
            }

        } catch (Exception e) {
            System.err.println("MySQL Health check failed " + e.getMessage());
        }

        HealthResponse healthResponse = new HealthResponse(serviceName,
                serviceDescription,
                "Up",
                LocalDateTime.now());

        return healthResponse;
    }
}
