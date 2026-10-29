package com.ashutosh.gatekeeper.management.repository;

import com.ashutosh.gatekeeper.management.entity.Organization;
import com.ashutosh.gatekeeper.management.entity.OrganizationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Boolean existsByNameIgnoreCase(String name);

    Boolean existsBySlugIgnoreCase(String slug);

    List<Organization> findAllByStatusNot(OrganizationStatus status);

    Optional<Organization> findByIdAndStatusNot(Long id, OrganizationStatus status);
}
