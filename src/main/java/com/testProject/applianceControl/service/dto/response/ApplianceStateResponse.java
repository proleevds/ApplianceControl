package com.testProject.applianceControl.service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApplianceStateResponse {
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("state")
    private String state;

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.toString();
    }
}
