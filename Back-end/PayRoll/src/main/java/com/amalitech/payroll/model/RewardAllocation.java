package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RewardAllocation {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "userId", referencedColumnName = "userId",table = "Employee")
    private String userId;
    private String type;
    private String rewardName;
    private String startMonth;
    private Long amount;

}
