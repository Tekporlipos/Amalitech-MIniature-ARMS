package com.amalitech.payroll.repository;

import com.amalitech.payroll.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    void deleteAllByPayRollCodeEquals(String code);
    Optional<Employee> findByUserId(String userId);
}
