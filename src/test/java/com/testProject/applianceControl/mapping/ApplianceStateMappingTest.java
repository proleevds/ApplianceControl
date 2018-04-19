package com.testProject.applianceControl.mapping;

import com.testProject.applianceControl.BaseTest;
import com.testProject.applianceControl.jpa.ApplianceType;
import com.testProject.applianceControl.jpa.oven.OvenEntity;
import com.testProject.applianceControl.jpa.state.ApplianceStateEntity;
import com.testProject.applianceControl.service.dto.request.OvenRequest;
import com.testProject.applianceControl.service.dto.response.ApplianceStateResponse;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
public class ApplianceStateMappingTest extends BaseTest {
    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void testStateEntityToStateResponseConversion() {
        final ApplianceStateEntity stateEntity = new ApplianceStateEntity(321L,
                new Timestamp(System.currentTimeMillis()), 123L, ApplianceStateEntity.State.STANDBY);
        final ApplianceStateResponse stateResponse = modelMapper.map(stateEntity, ApplianceStateResponse.class);

        Assert.assertEquals(stateEntity.getState().name(), stateResponse.getState());
        Assert.assertEquals(stateEntity.getTimestamp().toString(), stateResponse.getTimestamp());
    }

    @Test
    public void testStateRequestToStateEntityConversion() {
        final OvenRequest oven = new OvenRequest("test1", 2017);
        final OvenEntity ovenEntity = modelMapper.map(oven, OvenEntity.class);
        Assert.assertEquals(ovenEntity.getModel(), oven.getModel());
        Assert.assertEquals(ovenEntity.getModelYear(), oven.getModelYear());
        Assert.assertEquals(ovenEntity.getType(), ApplianceType.OVEN);
    }
}
