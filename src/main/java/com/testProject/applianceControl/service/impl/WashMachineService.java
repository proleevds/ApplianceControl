package com.testProject.applianceControl.service.impl;

import com.testProject.applianceControl.jpa.washMachine.WashMachineEntity;
import com.testProject.applianceControl.jpa.washMachine.WashMachineRepository;
import com.testProject.applianceControl.service.IApplianceStateService;
import com.testProject.applianceControl.service.IWashMachineService;
import com.testProject.applianceControl.service.dto.request.ApplianceRequest;
import com.testProject.applianceControl.service.dto.response.ApplianceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WashMachineService implements IWashMachineService {
    private final WashMachineRepository washMachineRepository;
    private final IApplianceStateService stateService;
    private final ModelMapper modelMapper;

    @Autowired
    public WashMachineService(final WashMachineRepository washMachineRepository, IApplianceStateService stateService, ModelMapper modelMapper) {
        this.washMachineRepository = washMachineRepository;
        this.stateService = stateService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<ApplianceResponse> persistAppliance(final ApplianceRequest washMachine) {
        try {
            final WashMachineEntity entity = modelMapper.map(washMachine, WashMachineEntity.class);
            final WashMachineEntity savedEntity = washMachineRepository.save(entity);
            return Optional.of(modelMapper.map(savedEntity, ApplianceResponse.class));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ApplianceResponse> getAppliance(final Long id) {
        try {
            final WashMachineEntity washMachineEntity = washMachineRepository.findOne(id);
            final ApplianceResponse applianceResponse = modelMapper.map(washMachineEntity, ApplianceResponse.class);
            injectState(applianceResponse);
            return Optional.of(applianceResponse);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private void injectState(ApplianceResponse applianceResponse) {
        stateService.retrieveLastState(applianceResponse.getId())
                .ifPresent(applianceResponse::setState);
    }
}