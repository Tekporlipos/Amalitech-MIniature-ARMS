package com.amalitech.payroll.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private UUID userId;
    private String name;
    private String email;
    private String profile;
    private String role;
}
