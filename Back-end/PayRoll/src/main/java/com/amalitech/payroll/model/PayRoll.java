package com.amalitech.payroll.model;

import lombok.Data;

import java.util.UUID;

@Data
public class PayRoll {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String otherName;
    private String profile;
    private String email;
    private String tell;
    private String department;
    private String position;
    private String role;
    private String  hireDate;
    private String salary;
    private String bonus;
    private String allowance;
    private String ssf;
    private String payRollCode;
}
