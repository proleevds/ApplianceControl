package com.testProject.applianceControl.repositoryLayer;

import com.testProject.applianceControl.BaseTest;
import com.testProject.applianceControl.jpa.ApplianceType;
import com.testProject.applianceControl.jpa.washMachine.WashMachineEntity;
import com.testProject.applianceControl.jpa.washMachine.WashMachineRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class WashMachineRepositoryTest extends BaseTest {
    @Autowired
    private WashMachineRepository washMachineRepository;

    @Test
    public void createWashMachine() {
        final WashMachineEntity savedWashMachineEntity = washMachineRepository.save(
                new WashMachineEntity("createWashMachine"));
        Assert.assertNotNull(savedWashMachineEntity.getId());
    }

    @Test
    public void createAndRetrieve() {
        final String model = "createAndRetrieve";
        final WashMachineEntity washMachineEntity = new WashMachineEntity(model);
        final WashMachineEntity savedWashMachineEntity = washMachineRepository.save(washMachineEntity);
        final WashMachineEntity foundWashMachineEntity = washMachineRepository.findOne(savedWashMachineEntity.getId());
        Assert.assertEquals(washMachineEntity.getModel(), foundWashMachineEntity.getModel());
        Assert.assertEquals(washMachineEntity.getType(), ApplianceType.WASH_MACHINE);
    }
}
