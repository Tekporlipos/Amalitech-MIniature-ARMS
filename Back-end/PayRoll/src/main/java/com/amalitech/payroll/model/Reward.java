package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;


@Entity
@Table(name = "reward")
@Data
public class Reward {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(unique = true,nullable = false)
    private String name;
    private String description;
}
