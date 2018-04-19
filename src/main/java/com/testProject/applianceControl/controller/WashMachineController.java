package com.testProject.applianceControl.controller;

import com.testProject.applianceControl.service.IWashMachineService;
import com.testProject.applianceControl.service.dto.request.ApplianceRequest;
import com.testProject.applianceControl.service.dto.response.ApplianceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/washMachine")
public class WashMachineController {
    private final IWashMachineService washMachineService;

    @Autowired
    public WashMachineController(IWashMachineService washMachineService) {
        this.washMachineService = washMachineService;
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApplianceResponse> createOven(@RequestBody final ApplianceRequest washMachine) {
        return washMachineService.persistAppliance(washMachine)
                .map(entity -> ResponseEntity.ok().body(entity))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApplianceResponse> getWashMachine(@PathVariable("id") final Long id) {
        return washMachineService.getAppliance(id)
                .map(washMachine -> ResponseEntity.ok().body(washMachine))
                .orElse(ResponseEntity.noContent().build());

    }
}
