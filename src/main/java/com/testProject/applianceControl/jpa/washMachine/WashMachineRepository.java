package com.testProject.applianceControl.jpa.washMachine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WashMachineRepository extends CrudRepository<WashMachineEntity, Long> {
}
