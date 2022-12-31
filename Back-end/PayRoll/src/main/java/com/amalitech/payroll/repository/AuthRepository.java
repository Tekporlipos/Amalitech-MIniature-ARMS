package com.amalitech.payroll.repository;


import com.amalitech.payroll.model.Auth;
import com.amalitech.payroll.model.Reward;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth, Long> {

    Optional<Auth> findByTokenAndExpireGreaterThan(String token,Long expire);
}
