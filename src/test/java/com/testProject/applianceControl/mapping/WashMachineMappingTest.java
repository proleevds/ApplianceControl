package com.testProject.applianceControl.mapping;

import com.testProject.applianceControl.BaseTest;
import com.testProject.applianceControl.jpa.ApplianceType;
import com.testProject.applianceControl.jpa.washMachine.WashMachineEntity;
import com.testProject.applianceControl.service.dto.request.ApplianceRequest;
import com.testProject.applianceControl.service.dto.response.ApplianceResponse;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WashMachineMappingTest extends BaseTest {
    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void testWashMachineEntityToWashMachineResponseConversion() {
        final WashMachineEntity entity = new WashMachineEntity("test");
        final ApplianceResponse dto = modelMapper.map(entity, ApplianceResponse.class);
        Assert.assertEquals(entity.getModel(), dto.getModel());
        Assert.assertEquals(entity.getType().name(), dto.getType());
        Assert.assertEquals(entity.getId(), dto.getId());
    }

    @Test
    public void testApplianceRequestToWashMachineEntityConversion() {
        final ApplianceRequest dto = new ApplianceRequest("test1");
        final WashMachineEntity entity = modelMapper.map(dto, WashMachineEntity.class);
        Assert.assertEquals(entity.getModel(), dto.getModel());
        Assert.assertEquals(entity.getType(), ApplianceType.WASH_MACHINE);
    }
}
