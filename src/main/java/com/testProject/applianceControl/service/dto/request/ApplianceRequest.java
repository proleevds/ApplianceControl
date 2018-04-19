package com.testProject.applianceControl.service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
public class ApplianceRequest {
    @JsonProperty("model")
    private String model;

    public ApplianceRequest() {
    }
}
