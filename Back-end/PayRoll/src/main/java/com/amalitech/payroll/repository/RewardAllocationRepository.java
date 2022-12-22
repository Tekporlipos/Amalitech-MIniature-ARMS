package com.amalitech.payroll.repository;

import com.amalitech.payroll.model.RewardAllocation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RewardAllocationRepository extends CrudRepository<RewardAllocation, Long> {
    Optional<RewardAllocation> findByType(String type);
    Iterable<RewardAllocation> findAllByTypeAndUserId(String type,String userId);
}
