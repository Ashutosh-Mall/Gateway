package com.ashutosh.gatekeeper.management.controller;


import com.ashutosh.gatekeeper.management.entity.Organization;
import com.ashutosh.gatekeeper.management.service.OrganizationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/platform/organizations")
public class PlatformOrganizationController {
    private final OrganizationService organizationService;

    public PlatformOrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

//    @PostMapping
//    public Organization createOrganization(@RequestBody Organization organization) {
//
//    }
}
