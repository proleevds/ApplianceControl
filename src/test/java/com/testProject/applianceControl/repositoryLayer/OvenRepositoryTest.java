package com.testProject.applianceControl.repositoryLayer;

import com.testProject.applianceControl.BaseTest;
import com.testProject.applianceControl.jpa.ApplianceType;
import com.testProject.applianceControl.jpa.oven.OvenEntity;
import com.testProject.applianceControl.jpa.oven.OvenRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class OvenRepositoryTest extends BaseTest {
    @Autowired
    private OvenRepository ovenRepository;

    @Test
    public void createOven() {
        final OvenEntity savedOvenEntity = ovenRepository.save(
                new OvenEntity("createOven", 2018));
        Assert.assertNotNull(savedOvenEntity.getId());
    }

    @Test
    public void createAndRetrieve() {
        final int modelYear = 2019;
        final String model = "createAndRetrieve";
        final OvenEntity ovenEntity = new OvenEntity(model, modelYear);
        final OvenEntity savedOvenEntity = ovenRepository.save(ovenEntity);
        final OvenEntity foundOvenEntity = ovenRepository.findOne(savedOvenEntity.getId());
        Assert.assertEquals(ovenEntity.getModelYear(), foundOvenEntity.getModelYear());
        Assert.assertEquals(ovenEntity.getModel(), foundOvenEntity.getModel());
        Assert.assertEquals(ovenEntity.getType(), ApplianceType.OVEN);
    }
}
