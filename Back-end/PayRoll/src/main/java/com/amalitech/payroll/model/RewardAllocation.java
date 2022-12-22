package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RewardAllocation {
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String type;
    private String rewardName;
    private String startMonth;
    private String endMonth;
    private Long amount;

}
