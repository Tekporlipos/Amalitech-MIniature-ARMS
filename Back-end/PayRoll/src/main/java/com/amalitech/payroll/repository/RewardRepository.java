package com.amalitech.payroll.repository;


import com.amalitech.payroll.model.Reward;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RewardRepository extends CrudRepository<Reward, Long> {
    void deleteByName(String type);
    Optional<Reward> findByType(String type);
}
