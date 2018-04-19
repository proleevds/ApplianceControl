package com.testProject.applianceControl.service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class ApplianceStateRequest {
    @JsonProperty("state")
    protected String state;

    public ApplianceStateRequest(String state) {
        this.state = state;
    }

    public ApplianceStateRequest() {
    }
}
