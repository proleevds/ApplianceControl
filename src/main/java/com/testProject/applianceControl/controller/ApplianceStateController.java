package com.testProject.applianceControl.controller;

import com.testProject.applianceControl.service.IApplianceStateService;
import com.testProject.applianceControl.service.dto.request.ApplianceStateRequest;
import com.testProject.applianceControl.service.dto.response.ApplianceStateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("applianceState")
public class ApplianceStateController {
    private final IApplianceStateService stateService;

    @Autowired
    protected ApplianceStateController(IApplianceStateService stateService) {
        this.stateService = stateService;
    }

    @RequestMapping(value = "/{id}/change",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity changeState(@PathVariable(name = "id") final Long applianceId, @RequestBody final ApplianceStateRequest newState) {
        return stateService.persistApplianceState(applianceId, newState)
                .map(savedStateId -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApplianceStateResponse> getState(@PathVariable("id") final Long applianceId) {
        return stateService.retrieveLastState(applianceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }
}
