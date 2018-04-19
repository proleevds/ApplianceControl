package com.testProject.applianceControl.service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OvenRequest extends ApplianceRequest {
    @JsonProperty("modelYear")
    private Integer modelYear;

    public OvenRequest(String model, Integer modelYear) {
        super(model);
        this.modelYear = modelYear;
    }

    public OvenRequest() {
    }

    public Integer getModelYear() {
        return this.modelYear;
    }
}
