package com.testProject.applianceControl.service.impl;

import com.testProject.applianceControl.jpa.oven.OvenEntity;
import com.testProject.applianceControl.jpa.oven.OvenRepository;
import com.testProject.applianceControl.service.IApplianceStateService;
import com.testProject.applianceControl.service.IOvenService;
import com.testProject.applianceControl.service.dto.request.OvenRequest;
import com.testProject.applianceControl.service.dto.response.OvenResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OvenService implements IOvenService {
    private final OvenRepository ovenRepository;
    private final IApplianceStateService stateService;
    private final ModelMapper modelMapper;

    @Autowired
    public OvenService(final OvenRepository ovenRepository, final IApplianceStateService stateService, final ModelMapper modelMapper) {
        this.ovenRepository = ovenRepository;
        this.stateService = stateService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<OvenResponse> persistAppliance(final OvenRequest oven) {
        try {
            final OvenEntity ovenEntity = modelMapper.map(oven, OvenEntity.class);
            final OvenEntity savedEntity = ovenRepository.save(ovenEntity);
            return Optional.of(modelMapper.map(savedEntity, OvenResponse.class));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<OvenResponse> getAppliance(final Long id) {
        try {
            final OvenEntity ovenEntity = ovenRepository.findOne(id);
            final OvenResponse oven = modelMapper.map(ovenEntity, OvenResponse.class);
            injectState(oven);
            return Optional.of(oven);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private void injectState(OvenResponse ovenResponse) {
        stateService.retrieveLastState(ovenResponse.getId())
                .ifPresent(ovenResponse::setState);
    }
}
