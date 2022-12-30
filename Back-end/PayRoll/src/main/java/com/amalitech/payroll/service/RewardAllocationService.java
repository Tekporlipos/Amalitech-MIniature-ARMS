package com.amalitech.payroll.service;

import com.amalitech.payroll.contracts.RewardAllocationContract;
import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.repository.RewardAllocationRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RewardAllocationService implements RewardAllocationContract {

    final RewardAllocationRepository repository;

    @Override
    public ResponseData getAllReward() {
        Iterable<RewardAllocation> all = repository.findAll();
        return new ResponseData(Constants.OK,Constants.SUCCESS, convertArray(all));
    }


    @Override
    public ResponseData deleteRewardById(UUID uuid) {
        System.out.println(uuid);
        repository.deleteById(uuid);
        return new ResponseData(Constants.OK,Constants.SUCCESS, Map.of("message"," deleted successful"));
    }

    @Override
    public ResponseData addReward(Reward reward) {
        return RewardAllocationContract.super.addReward(reward);
    }

    public ResponseData getAllRewardByType(String userId, String type,String department) {
        Iterable<RewardAllocation> all = repository.findAllByTypeAndUserId(userId, type.trim().toLowerCase(), department.trim().toLowerCase());
        return new ResponseData(Constants.OK,Constants.SUCCESS, convertArray(all));
    }


    @Override
    public ResponseData addRewardAllocation(RewardAllocation rewardAllocation) {
        rewardAllocation.setUserId(rewardAllocation.getUserId().trim().toLowerCase());
        rewardAllocation.setType(rewardAllocation.getType().trim().toLowerCase());
        RewardAllocation save = repository.save(rewardAllocation);
        return new ResponseData(Constants.OK,Constants.SUCCESS,save);
    }


    public Object convertArray(Iterable<RewardAllocation> all){
        ArrayList<RewardAllocation> arrayList = new ArrayList<>();
        all.forEach(arrayList::add);
        return arrayList;
    }

}
