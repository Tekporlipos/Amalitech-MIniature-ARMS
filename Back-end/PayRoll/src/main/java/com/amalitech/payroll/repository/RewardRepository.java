package com.amalitech.payroll.repository;


import com.amalitech.payroll.model.Reward;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RewardRepository extends CrudRepository<Reward, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE  FROM reward WHERE name = ?1", nativeQuery = true)
    void deleteByName(String name);
    Iterable<Reward> findByType(String type);
}
