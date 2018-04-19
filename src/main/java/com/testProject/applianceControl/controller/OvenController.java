package com.testProject.applianceControl.controller;

import com.testProject.applianceControl.service.IOvenService;
import com.testProject.applianceControl.service.dto.request.OvenRequest;
import com.testProject.applianceControl.service.dto.response.OvenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oven")
public class OvenController {
    private final IOvenService ovenService;

    @Autowired
    public OvenController(final IOvenService ovenService) {
        this.ovenService = ovenService;
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<OvenResponse> createOven(@RequestBody final OvenRequest oven) {
        return ovenService.persistAppliance(oven)
                .map(createdOven -> ResponseEntity.ok().body(createdOven))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<OvenResponse> getOven(@PathVariable("id") final Long id) {
        return ovenService.getAppliance(id)
                .map(oven -> ResponseEntity.ok().body(oven))
                .orElse(ResponseEntity.noContent().build());
    }
}
