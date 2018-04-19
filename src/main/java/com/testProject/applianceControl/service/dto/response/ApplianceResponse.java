package com.testProject.applianceControl.service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplianceResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("model")
    private String model;
    @JsonProperty("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApplianceStateResponse state;

    public ApplianceResponse() {
    }

    public void setState(ApplianceStateResponse state) {
        this.state = state;
    }

    public Long getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getModel() {
        return this.model;
    }

    public ApplianceStateResponse getState() {
        return this.state;
    }
}
