package com.testProject.applianceControl.jpa.washMachine;

import com.testProject.applianceControl.jpa.AbstractAppliance;
import com.testProject.applianceControl.jpa.ApplianceType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "appliance")
public class WashMachineEntity extends AbstractAppliance {
    public WashMachineEntity(final String model) {
        super(ApplianceType.WASH_MACHINE, model);
    }

    public WashMachineEntity() {
        super();
        this.type = ApplianceType.WASH_MACHINE;
    }
}