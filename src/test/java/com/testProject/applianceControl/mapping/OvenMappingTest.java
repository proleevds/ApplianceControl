package com.testProject.applianceControl.mapping;

import com.testProject.applianceControl.BaseTest;
import com.testProject.applianceControl.jpa.ApplianceType;
import com.testProject.applianceControl.jpa.oven.OvenEntity;
import com.testProject.applianceControl.service.dto.request.OvenRequest;
import com.testProject.applianceControl.service.dto.response.OvenResponse;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OvenMappingTest extends BaseTest {
    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void testOvenEntityToOvenResponseConversion() {
        final OvenEntity ovenEntity = new OvenEntity("test", 2005);
        final OvenResponse oven = modelMapper.map(ovenEntity, OvenResponse.class);
        Assert.assertEquals(ovenEntity.getModel(), oven.getModel());
        Assert.assertEquals(ovenEntity.getType().name(), oven.getType());
        Assert.assertEquals(ovenEntity.getModelYear(), oven.getModelYear());
        Assert.assertEquals(ovenEntity.getId(), oven.getId());
    }

    @Test
    public void testApplianceRequestToOvenEntityConversion() {
        final OvenRequest oven = new OvenRequest("test1", 2017);
        final OvenEntity ovenEntity = modelMapper.map(oven, OvenEntity.class);
        Assert.assertEquals(ovenEntity.getModel(), oven.getModel());
        Assert.assertEquals(ovenEntity.getModelYear(), oven.getModelYear());
        Assert.assertEquals(ovenEntity.getType(), ApplianceType.OVEN);
    }
}
