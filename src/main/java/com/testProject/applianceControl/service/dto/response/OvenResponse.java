package com.testProject.applianceControl.service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OvenResponse extends ApplianceResponse {
    @JsonProperty("modelYear")
    private Integer modelYear;

    public Integer getModelYear() {
        return this.modelYear;
    }
}
