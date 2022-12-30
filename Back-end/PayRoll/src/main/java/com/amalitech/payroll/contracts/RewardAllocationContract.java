package com.amalitech.payroll.contracts;

import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.utils.ResponseData;

import java.util.UUID;

public interface RewardAllocationContract extends RewardContract{
    ResponseData deleteRewardById(UUID id);
    ResponseData addRewardAllocation(RewardAllocation rewardAllocation);

}
