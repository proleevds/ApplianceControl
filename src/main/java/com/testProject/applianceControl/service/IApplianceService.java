package com.testProject.applianceControl.service;

import com.testProject.applianceControl.service.dto.request.ApplianceRequest;
import com.testProject.applianceControl.service.dto.response.ApplianceResponse;

import java.util.Optional;

public interface IApplianceService<X extends ApplianceRequest, Y extends ApplianceResponse> {
    Optional<Y> persistAppliance(final X appliance);

    Optional<Y> getAppliance(final Long id);
}
