package com.amalitech.payroll.service;

import com.amalitech.payroll.contracts.RewardAllocationContract;
import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.model.RewardAllocationDTO;
import com.amalitech.payroll.model.RewardDTO;
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
    public ResponseData deleteRewardById(Long uuid) {
        repository.deleteById(uuid);
        return new ResponseData(Constants.OK,Constants.SUCCESS, Map.of("message"," deleted successful"));
    }

    @Override
    public ResponseData addReward(RewardDTO reward) {
        return RewardAllocationContract.super.addReward(reward);
    }

    public ResponseData getAllRewardByType(String userId, String type,String department) {
        Iterable<RewardAllocation> all = repository.findAllByTypeAndUserId(userId, type.trim().toLowerCase(), department.trim().toLowerCase());
        return new ResponseData(Constants.OK,Constants.SUCCESS, convertArray(all));
    }


    @Override
    public ResponseData addRewardAllocation(RewardAllocationDTO rewardAllocationDTO) {
        RewardAllocation rewardAllocation = new RewardAllocation();

        rewardAllocation.setUserId(rewardAllocationDTO.getUserId().trim().toLowerCase());
        rewardAllocation.setType(rewardAllocationDTO.getType().trim().toLowerCase());
        rewardAllocation.setRewardName(rewardAllocationDTO.getRewardName());
        rewardAllocation.setAmount(rewardAllocationDTO.getAmount());
        rewardAllocation.setUserId(rewardAllocationDTO.getUserId());

        RewardAllocation save = repository.save(rewardAllocation);
        return new ResponseData(Constants.OK,Constants.SUCCESS,save);
    }


    public Object convertArray(Iterable<RewardAllocation> all){
        ArrayList<RewardAllocation> arrayList = new ArrayList<>();
        all.forEach(arrayList::add);
        return arrayList;
    }

}
