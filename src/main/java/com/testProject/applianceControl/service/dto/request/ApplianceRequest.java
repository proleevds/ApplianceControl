package com.testProject.applianceControl.service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplianceRequest {
    @JsonProperty("model")
    private String model;

    public ApplianceRequest() {
    }

    public ApplianceRequest(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }
}
