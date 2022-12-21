package com.amalitech.payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reward_allocation")
public class RewardAllocation {
    @Id
    @GeneratedValue
    private long id;

    private String type;

    private String startDate;
    private String endDate;
    private String userId;
    private String amount;

}
