package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class RewardAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String userId;
    private String type;
    private String rewardName;
    private String startMonth;
    private Long amount;

}
