package com.amalitech.payroll.model;

import lombok.Data;

@Data
public class RewardAllocationDTO {
    private String userId;
    private String type;
    private String rewardName;
    private String startMonth;
    private Long amount;

}
