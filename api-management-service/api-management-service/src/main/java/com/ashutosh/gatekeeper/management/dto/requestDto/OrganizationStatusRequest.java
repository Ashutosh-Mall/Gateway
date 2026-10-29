package com.ashutosh.gatekeeper.management.dto.requestDto;

import com.ashutosh.gatekeeper.management.entity.OrganizationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationStatusRequest {
    private OrganizationStatus status;
}
