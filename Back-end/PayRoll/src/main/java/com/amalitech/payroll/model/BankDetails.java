package com.amalitech.payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Map;

@Entity
@Data
public class BankDetails {


    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private Long batch;
    private String payRollCode;
    private String position;
    private String role;
    private String hireDate;
    private String department;
    private Double salary;
    private Double allowance;
    private Double bonus;
    private Double ssf;

    public BankDetails convert(Map<String,Object> data, Double allowance, Double bonus,String month){
        setPayRollCode(month);
        setUserId(String.valueOf(data.get("user_id")));
        setRole(String.valueOf(data.get("role")));
        setHireDate(String.valueOf(data.get("hire_date")));
        setDepartment(String.valueOf(data.get("department")));
        setPosition(String.valueOf(data.get("position")));
        setSalary(Double.parseDouble(String.valueOf(data.get("salary"))));
        setSsf(Double.parseDouble(String.valueOf(data.get("salary"))) * 0.05);
        setAllowance(allowance);
        setBonus(bonus);
        return this;
    }
}
