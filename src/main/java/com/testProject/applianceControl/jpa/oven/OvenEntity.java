package com.testProject.applianceControl.jpa.oven;

import com.testProject.applianceControl.jpa.AbstractAppliance;
import com.testProject.applianceControl.jpa.ApplianceType;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "appliance")
@Getter
public class OvenEntity extends AbstractAppliance {
    private Integer modelYear;

    public OvenEntity(final String model, Integer modelYear) {
        super(ApplianceType.OVEN, model);
        this.modelYear = modelYear;
    }

    public OvenEntity() {
        super();
        this.type = ApplianceType.OVEN;
    }
}