package com.amalitech.payroll.repository;

import com.amalitech.payroll.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByUserId(String userId);
    @Modifying
    @Transactional
    @Query(value = "SELECT E.user_id, E.first_name,E.last_name, E.other_name,E.gender,E.profile,E.email,E.tell,B.department, " +
            "B.position, B.role, B.hire_date,B.salary,B.bonus,B.allowance,B.ssf,B.pay_roll_code FROM EMPLOYEE AS E, " +
            "BANK_DETAILS AS B WHERE  E.user_id =B.user_id AND  E.batch =B.batch AND  E.pay_roll_code=B.pay_roll_code  "+
            "AND E.batch = ?2 AND E.pay_roll_code = ?1 ORDER BY  E.id DESC limit ?3 OFFSET ?4"
            , nativeQuery = true)
    Iterable<Map<String, Object>> findAllByBatchAndPayCodeWithLimitAndOffSet(String payCode, Long batch, Long limit, Long page);
    long countAllByBatchAndPayRollCode(Long batch,String code);
}
