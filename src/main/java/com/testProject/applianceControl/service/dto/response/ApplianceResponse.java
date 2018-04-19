package com.testProject.applianceControl.service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class ApplianceResponse {
    @JsonProperty("id")
    protected Long id;
    @JsonProperty("type")
    protected String type;
    @JsonProperty("model")
    protected String model;
    @JsonProperty("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected ApplianceStateResponse state;

    public ApplianceResponse() {
    }

    public void setState(ApplianceStateResponse state) {
        this.state = state;
    }
}
