package com.amalitech.payroll.repository;

import com.amalitech.payroll.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Modifying
    @Transactional
    @Query(value = "SELECT E.user_id, E.first_name,E.last_name, E.other_name,E.gender,E.profile,E.email,E.tell,B.department, " +
            "B.position, B.role, B.hire_date,B.salary,B.bonus,B.allowance,B.ssf,B.pay_roll_code FROM EMPLOYEE AS E, " +
            "BANK_DETAILS AS B WHERE  E.user_id =B.user_id AND  E.batch =B.batch AND  E.pay_roll_code=B.pay_roll_code  "+
            "AND E.batch = ?2 AND E.pay_roll_code = ?1 ORDER BY  E.id DESC limit ?3 OFFSET ?4"
            , nativeQuery = true)
    Iterable<Map<String, Object>> findAllByBatchAndPayCodeWithLimitAndOffSet(String payCode, Long batch, Long limit, Long page);


    @Modifying
    @Transactional
    @Query(value = "SELECT E.user_id, E.first_name,E.last_name, E.other_name,E.gender,E.profile,E.email,E.tell,B.department,  B.position, B.role, B.hire_date,B.salary,B.bonus,B.allowance,B.ssf,B.pay_roll_code " +
            "FROM EMPLOYEE AS E, BANK_DETAILS AS B WHERE  E.user_id =B.user_id AND  E.batch =B.batch AND  E.pay_roll_code=B.pay_roll_code AND " +
            "( E.first_name LIKE  ?3 OR E.last_name LIKE  ?3 OR  E.other_name LIKE  ?3 OR E.email LIKE ?3)" +
            "AND E.batch = ?1 AND E.pay_roll_code = ?2 ORDER BY  E.id DESC limit ?5 OFFSET ?4"
            , nativeQuery = true)
    Iterable<Map<String, Object>>  searchAllByBatchAndPayRollCodeOrFirstNameOrLastNameOrOtherNameWithLimitAndOffSet(Long batch, String payCode, String search, Integer page, Integer limit);



    @Modifying
    @Transactional
    @Query(value = "SELECT E.user_id, E.first_name,E.last_name, E.other_name,E.gender,E.profile,E.email,E.tell,B.department," +
            " B.position, B.role, B.hire_date,B.salary,B.bonus,B.allowance,B.ssf,B.pay_roll_code FROM EMPLOYEE AS E, " +
            "BANK_DETAILS AS B WHERE  E.user_id =B.user_id AND  E.batch =B.batch AND  E.pay_roll_code=B.pay_roll_code  " +
            " AND E.batch = ?2 AND E.pay_roll_code = ?1 AND E.user_id = ?3  LIMIT 1;"
            , nativeQuery = true)
    Iterable<Map<String, Object>> findByPayRollCodeAndBatchAndUserId(String payCode, Long batch,String userId);

    long countAllByBatchAndPayRollCode(Long batch,String code);

    @Modifying
    @Transactional
    @Query(value = "SELECT DISTINCT pay_roll_code FROM employee"
            , nativeQuery = true)
    Iterable<String> findAllPayCode();
}
