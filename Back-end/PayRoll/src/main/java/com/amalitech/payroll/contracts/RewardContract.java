package com.amalitech.payroll.contracts;

import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.utils.ResponseData;


public interface RewardContract {
    ResponseData getAllReward();
    ResponseData getAllRewardByType(String type);
    ResponseData deleteRewardByName(String name);
    ResponseData addReward(Reward reward);
}
