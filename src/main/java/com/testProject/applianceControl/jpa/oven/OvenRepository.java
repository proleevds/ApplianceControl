package com.testProject.applianceControl.jpa.oven;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvenRepository extends CrudRepository<OvenEntity, Long> {
}
