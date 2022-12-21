package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RewardAllocation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users users;
    private String rewardName;
    private String type;
    private String startMonth;
    private Long amount;

}
