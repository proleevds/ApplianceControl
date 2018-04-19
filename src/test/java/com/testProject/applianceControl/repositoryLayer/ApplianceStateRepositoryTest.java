package com.testProject.applianceControl.repositoryLayer;

import com.testProject.applianceControl.BaseTest;
import com.testProject.applianceControl.jpa.state.ApplianceStateEntity;
import com.testProject.applianceControl.jpa.state.ApplianceStateRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@DataJpaTest
public class ApplianceStateRepositoryTest extends BaseTest {
    @Autowired
    private ApplianceStateRepository stateRepository;

    @Test
    public void createNewState() {
        final ApplianceStateEntity stateEntity = stateRepository.save(
                new ApplianceStateEntity(123456L, ApplianceStateEntity.State.OFF));
        Assert.assertNotNull(stateEntity.getId());
    }

    @Test
    public void createAndRetrieveState() {
        final long applianceId = 541321L;
        final ApplianceStateEntity.State state = ApplianceStateEntity.State.STANDBY;
        final ApplianceStateEntity washMachineStateEntity = new ApplianceStateEntity(applianceId, state);
        final ApplianceStateEntity savedWashMachineStateEntity = stateRepository.save(washMachineStateEntity);
        final ApplianceStateEntity foundWashMachineStateEntity = stateRepository.findOne(savedWashMachineStateEntity.getId());
        Assert.assertEquals(washMachineStateEntity.getApplianceId(), foundWashMachineStateEntity.getApplianceId());
        Assert.assertEquals(washMachineStateEntity.getState(), foundWashMachineStateEntity.getState());
        Assert.assertNotNull(foundWashMachineStateEntity.getTimestamp());
    }

    @Test
    public void createMultipleStatesAndRetrieveLast() {
        final long applianceId = 541321L;
        final ApplianceStateEntity.State firstState = ApplianceStateEntity.State.STANDBY;
        final ApplianceStateEntity.State lastState = ApplianceStateEntity.State.OFF;

        final ApplianceStateEntity firstStateEntity = new ApplianceStateEntity(applianceId, firstState);
        stateRepository.save(firstStateEntity);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        final ApplianceStateEntity lastStateEntity = new ApplianceStateEntity(applianceId, lastState);
        stateRepository.save(lastStateEntity);
        final Page<ApplianceStateEntity> foundStates = stateRepository.findByApplianceIdOrderByTimestampDesc(applianceId,
                new PageRequest(0, 2));
        Assert.assertTrue(foundStates.hasContent());
        Assert.assertTrue(foundStates.getTotalElements() == 2);

        Assert.assertEquals(foundStates.getContent().get(0).getApplianceId(), lastStateEntity.getApplianceId());
        Assert.assertEquals(foundStates.getContent().get(0).getState(), lastStateEntity.getState());

        Assert.assertEquals(foundStates.getContent().get(1).getApplianceId(), firstStateEntity.getApplianceId());
        Assert.assertEquals(foundStates.getContent().get(1).getState(), firstStateEntity.getState());
    }
}
