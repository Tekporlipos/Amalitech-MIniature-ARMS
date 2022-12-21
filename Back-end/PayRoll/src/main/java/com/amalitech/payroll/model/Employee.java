package com.amalitech.payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private UUID userId;
    private String firstName;
    private String lastName;
    private String otherName;
    private String email;
    private String profile;
    private String role;
}
