package com.amalitech.payroll.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class RewardAllocation {
    @javax.persistence.Id
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String type;
    private String rewardName;
    private String startMonth;
    private Long amount;

}
