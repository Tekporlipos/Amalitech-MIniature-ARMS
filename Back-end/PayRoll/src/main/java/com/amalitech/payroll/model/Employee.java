package com.amalitech.payroll.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Map;
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String payRollCode;
    private String userId;
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String profile;
    private String role;
    private String hireDate;
    private String department;
    private Double salary;
    private Double allowance;
    private Double bonus;
    private Double ssf;


    public Employee convert(Map<String,Object> data,Double allowance, Double bonus){
        final Calendar instance = Calendar.getInstance();
        setPayRollCode(instance.get(Calendar.YEAR)+""+instance.get(Calendar.MONTH));
        setUserId(String.valueOf(data.get("user_id")));
        setFirstName(String.valueOf(data.get("first_name")));
        setLastName(String.valueOf(data.get("last_name")));
        setOtherName(String.valueOf(data.get("other_names")));
        setProfile(String.valueOf(data.get("profile")));
        setRole(String.valueOf(data.get("role")));
        setGender(String.valueOf(data.get("gender")));
        setHireDate(String.valueOf(data.get("hire_date")));
        setDepartment(String.valueOf(data.get("department")));
        setSalary(Double.parseDouble(String.valueOf(data.get("salary"))));
        setSsf(Double.parseDouble(String.valueOf(data.get("salary"))) * 0.05);
        setAllowance(allowance);
        setBonus(bonus);
        return this;
    }
}