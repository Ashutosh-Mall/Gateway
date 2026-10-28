package com.ashutosh.gatekeeper.management.service;

import com.ashutosh.gatekeeper.management.repository.ManagementUserRepository;
import com.ashutosh.gatekeeper.management.repository.OrganizationRepository;
import com.ashutosh.gatekeeper.management.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final ManagementUserRepository managementUserRepository;
    private final RoleRepository roleRepository;

    public OrganizationService(OrganizationRepository organizationRepository,
                               ManagementUserRepository managementUserRepository,
                               RoleRepository roleRepository) {
        this.organizationRepository = organizationRepository;
        this.managementUserRepository = managementUserRepository;
        this.roleRepository = roleRepository;
    }

}
