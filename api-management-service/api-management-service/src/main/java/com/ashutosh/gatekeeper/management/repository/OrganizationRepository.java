package com.ashutosh.gatekeeper.management.repository;

import com.ashutosh.gatekeeper.management.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
