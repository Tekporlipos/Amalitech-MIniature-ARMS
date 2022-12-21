package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users users;
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String role;
    private String hireDate;
    private String department;
    private String salary;
    private String ssf;
}
