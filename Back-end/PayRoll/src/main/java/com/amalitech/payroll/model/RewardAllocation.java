package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RewardAllocation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users users;
    private String rewardName;
    private String type;

    private String month;
    private String amount;

}
