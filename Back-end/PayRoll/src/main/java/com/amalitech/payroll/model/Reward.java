package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "reward")
public class Reward {
    @Id
    @GeneratedValue
    private Long id;
    @Column()
    private String type;
    @Column(unique = true)
    private String name;
}
