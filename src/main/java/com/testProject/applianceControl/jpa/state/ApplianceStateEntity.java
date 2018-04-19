package com.testProject.applianceControl.jpa.state;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "state")
public class ApplianceStateEntity {
    @NotNull
    private Long applianceId;
    @NotNull
    private State state;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private Timestamp timestamp;

    public ApplianceStateEntity() {
    }

    public ApplianceStateEntity(Long applianceId, State state) {
        this.applianceId = applianceId;
        this.state = state;
    }

    public ApplianceStateEntity(Long id, Timestamp timestamp, Long applianceId, State state) {
        this.id = id;
        this.timestamp = timestamp;
        this.applianceId = applianceId;
        this.state = state;
    }

    public void setApplianceId(Long applianceId) {
        this.applianceId = applianceId;
    }

    public void setState(String state) {
        this.state = State.valueOf(state);
    }

    public Long getApplianceId() {
        return this.applianceId;
    }

    public State getState() {
        return this.state;
    }

    public Long getId() {
        return this.id;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public enum State {
        UNKNOWN, ON, OFF, STANDBY
    }
}
