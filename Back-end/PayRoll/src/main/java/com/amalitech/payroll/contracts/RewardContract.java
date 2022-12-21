package com.amalitech.payroll.contracts;

import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.utils.ResponseData;


public interface RewardContract {
    ResponseData getAllReward();
    ResponseData getAllRewardByType(String type);
    default ResponseData deleteRewardByName(String name) {
        return null;
    }
    default ResponseData addReward(Reward reward) {
        return null;
    }
}
