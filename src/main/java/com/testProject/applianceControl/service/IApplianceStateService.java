package com.testProject.applianceControl.service;

import com.testProject.applianceControl.service.dto.request.ApplianceStateRequest;
import com.testProject.applianceControl.service.dto.response.ApplianceStateResponse;

import java.util.Optional;

public interface IApplianceStateService {
    Optional<Long> persistApplianceState(final Long applianceId, final ApplianceStateRequest applianceStateRequest);

    Optional<ApplianceStateResponse> retrieveLastState(final Long applianceId);
}
