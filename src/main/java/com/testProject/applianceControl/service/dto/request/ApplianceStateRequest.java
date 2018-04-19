package com.testProject.applianceControl.service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplianceStateRequest {
    @JsonProperty("state")
    private String state;

    public ApplianceStateRequest(String state) {
        this.state = state;
    }

    public ApplianceStateRequest() {
    }

    public String getState() {
        return this.state;
    }
}
