package com.amalitech.payroll.service;

import com.amalitech.payroll.contracts.RewardContract;
import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.repository.RewardRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RewardService implements RewardContract {
    final RewardRepository rewardRepository;

    @Override
    public ResponseData getAllReward() {
        final Iterable<Reward> all = rewardRepository.findAll();
        ArrayList<Reward> arrayList = new ArrayList<>();
        all.forEach(value->arrayList.add(value));
        return new ResponseData(Constants.OK,Constants.SUCCESS,arrayList);
    }

    @Override
    public ResponseData getAllRewardByType(String type) {
        Optional<Reward> byType = rewardRepository.findByType(type);
        return new ResponseData(Constants.OK,Constants.SUCCESS, byType.isPresent()? byType.get(): Arrays.asList());
    }

    @Override
    public ResponseData deleteRewardByName(String name) {
        rewardRepository.deleteByName(name);
        return new ResponseData(Constants.OK,Constants.SUCCESS, Map.of("message","delete successful"));
    }

    @Override
    public ResponseData addReward(Reward reward) {
        return new ResponseData(Constants.OK,Constants.SUCCESS,rewardRepository.save(reward));
    }


}
