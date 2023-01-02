package com.amalitech.payroll.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Auth {
    @Id
    @GeneratedValue
    private Long id;
    private String token;
    private String role;
    private Long expire;
}
