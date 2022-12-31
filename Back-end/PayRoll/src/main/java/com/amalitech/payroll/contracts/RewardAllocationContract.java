package com.amalitech.payroll.contracts;

import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.model.RewardAllocationDTO;
import com.amalitech.payroll.utils.ResponseData;

import java.util.UUID;

public interface RewardAllocationContract extends RewardContract{
    ResponseData deleteRewardById(Long id);
    ResponseData addRewardAllocation(RewardAllocationDTO rewardAllocation);

}
