package com.testProject.applianceControl.jpa.state;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceStateRepository extends PagingAndSortingRepository<ApplianceStateEntity, Long> {
    Page<ApplianceStateEntity> findByApplianceIdOrderByTimestampDesc(Long id, Pageable pageable);
}
