package com.amalitech.payroll.service;

import com.amalitech.payroll.contracts.RewardAllocationContract;
import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.repository.RewardAllocationRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RewardAllocationService implements RewardAllocationContract {

    final RewardAllocationRepository repository;

    @Override
    public ResponseData getAllReward() {
        Iterable<RewardAllocation> all = repository.findAll();
        ArrayList<RewardAllocation> arrayList = new ArrayList<>();
        all.forEach(arrayList::add);
        return new ResponseData(Constants.OK,Constants.SUCCESS,arrayList);
    }

    @Override
    public ResponseData getAllRewardByType(String type) {
        Optional<RewardAllocation> byType = repository.findByType(type);
        return new ResponseData(Constants.OK,Constants.SUCCESS, byType.isPresent()? byType.get(): Arrays.asList());
    }

    @Override
    public ResponseData deleteRewardByName(Long id) {
        repository.deleteById(id);
        return new ResponseData(Constants.OK,Constants.SUCCESS, Map.of("message"," deleted successful"));
    }

    @Override
    public ResponseData addRewardAllocation(RewardAllocation rewardAllocation) {
        RewardAllocation save = repository.save(rewardAllocation);
        System.out.println(rewardAllocation);
        return new ResponseData(Constants.OK,Constants.SUCCESS,save);
    }

}
