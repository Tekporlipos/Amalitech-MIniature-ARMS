package com.amalitech.payroll.contracts;

import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.utils.ResponseData;

public interface RewardAllocationContract extends RewardContract{
    ResponseData deleteRewardByName(Long id);
    ResponseData addRewardAllocation(RewardAllocation rewardAllocation);


}
