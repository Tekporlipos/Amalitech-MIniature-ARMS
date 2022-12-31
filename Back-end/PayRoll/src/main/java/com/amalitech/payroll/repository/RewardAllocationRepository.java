package com.amalitech.payroll.repository;

import com.amalitech.payroll.model.RewardAllocation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


public interface RewardAllocationRepository extends CrudRepository<RewardAllocation, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM reward_allocation WHERE (user_id = ?1 OR user_id = ?3) AND  type = ?2", nativeQuery = true)
    Iterable<RewardAllocation> findAllByTypeAndUserId(String userid,String type, String department);
}
