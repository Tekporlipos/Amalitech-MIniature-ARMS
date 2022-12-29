package com.amalitech.payroll.repository;

import com.amalitech.payroll.model.RewardAllocation;
import org.springframework.data.repository.CrudRepository;


public interface RewardAllocationRepository extends CrudRepository<RewardAllocation, Long> {
    Iterable<RewardAllocation> findAllByType(String type);
    Iterable<RewardAllocation> findAllByTypeAndUserId(String type, String userId);
}
