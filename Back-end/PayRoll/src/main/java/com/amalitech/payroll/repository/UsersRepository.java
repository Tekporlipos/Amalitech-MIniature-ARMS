package com.amalitech.payroll.repository;

import com.amalitech.payroll.model.Users;
import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<Users, Long> {
}
