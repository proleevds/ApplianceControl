package com.testProject.applianceControl.jpa;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Getter
public abstract class AbstractAppliance {
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    protected ApplianceType type;
    @NotNull
    protected String model;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    protected AbstractAppliance() {
    }

    protected AbstractAppliance(final ApplianceType type,
                                final String model) {
        this.type = type;
        this.model = model;
    }
}
