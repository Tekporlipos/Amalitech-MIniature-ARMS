package com.amalitech.payroll.contracts;

import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.model.RewardDTO;
import com.amalitech.payroll.utils.ResponseData;


public interface RewardContract {
    ResponseData getAllReward();

    default ResponseData getAllRewardByType(String type) {
        return null;
    }

    default ResponseData deleteRewardByName(String name) {
        return null;
    }
    default ResponseData addReward(RewardDTO reward) {
        return null;
    }
}
