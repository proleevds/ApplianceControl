package com.testProject.applianceControl.service.impl;

import com.testProject.applianceControl.jpa.state.ApplianceStateEntity;
import com.testProject.applianceControl.jpa.state.ApplianceStateRepository;
import com.testProject.applianceControl.service.IApplianceStateService;
import com.testProject.applianceControl.service.dto.request.ApplianceStateRequest;
import com.testProject.applianceControl.service.dto.response.ApplianceStateResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class ApplianceStateService implements IApplianceStateService {
    private static final PageRequest ONE_ENTITY_BY_PAGE = new PageRequest(0, 1);

    private final ApplianceStateRepository stateRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ApplianceStateService(final ApplianceStateRepository stateRepository, final ModelMapper modelMapper) {
        this.stateRepository = stateRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<Long> persistApplianceState(final Long applianceId, final ApplianceStateRequest applianceStateRequest) {
        try {
            final ApplianceStateEntity stateEntity = modelMapper.map(applianceStateRequest, ApplianceStateEntity.class);
            stateEntity.setApplianceId(applianceId);
            return Optional.of(stateRepository.save(stateEntity).getId());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ApplianceStateResponse> retrieveLastState(final Long applianceId) {
        try {
            final Page<ApplianceStateEntity> found = stateRepository.findByApplianceIdOrderByTimestampDesc(applianceId, ONE_ENTITY_BY_PAGE);
            final ApplianceStateResponse state;
            if (found.hasContent()) {
                state = modelMapper.map(found.getContent().get(0), ApplianceStateResponse.class);
            } else {
                state = new ApplianceStateResponse(new Timestamp(System.currentTimeMillis()).toString(),
                        ApplianceStateEntity.State.UNKNOWN.name());
            }
            return Optional.of(state);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
