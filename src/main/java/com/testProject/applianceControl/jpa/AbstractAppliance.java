package com.testProject.applianceControl.jpa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractAppliance {
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    protected ApplianceType type;
    @NotNull
    private String model;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    protected AbstractAppliance() {
    }

    protected AbstractAppliance(final ApplianceType type, final String model) {
        this.type = type;
        this.model = model;
    }

    public ApplianceType getType() {
        return this.type;
    }

    public String getModel() {
        return this.model;
    }

    public Long getId() {
        return this.id;
    }
}
