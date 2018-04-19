package com.testProject.applianceControl.service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplianceStateResponse {
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("state")
    private String state;

    public ApplianceStateResponse(String timestamp, String state) {
        this.timestamp = timestamp;
        this.state = state;
    }

    public ApplianceStateResponse() {
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.toString();
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getState() {
        return this.state;
    }
}
