package com.amalitech.payroll.service;

import com.amalitech.payroll.contracts.RewardContract;
import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.model.RewardDTO;
import com.amalitech.payroll.repository.RewardRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class RewardService implements RewardContract {
    final RewardRepository rewardRepository;

    @Override
    public ResponseData getAllReward() {
        final Iterable<Reward> all = rewardRepository.findAll();
        return new ResponseData(Constants.OK,Constants.SUCCESS,convertArray(all));
    }

    @Override
    public ResponseData getAllRewardByType(String type) {
        final Iterable<Reward> all = rewardRepository.findByType(type);
        return new ResponseData(Constants.OK,Constants.SUCCESS, convertArray(all));
    }

    @Override
    public ResponseData deleteRewardByName(String name) {
        rewardRepository.deleteByName(name.trim());
        return new ResponseData(Constants.OK,Constants.SUCCESS, Map.of("message","delete successful"));
    }

    @Override
    public ResponseData addReward(RewardDTO rewardDTO) {
        boolean error = false;
        Reward reward  = new Reward();
        reward.setDescription(rewardDTO.getDescription() == null?"":rewardDTO.getDescription().trim());
        reward.setName(rewardDTO.getName().trim());
        reward.setType(rewardDTO.getType().trim().toLowerCase());
        if(rewardDTO.getType().isEmpty() || rewardDTO.getName().isEmpty()){
            error = true;
        }

        return new ResponseData(error?Constants.BAD:Constants.OK,error?Constants.BAD_REQUEST:Constants.SUCCESS,error?"Sorry!, nothing to save.":rewardRepository.save(reward));
    }

    public Object convertArray(Iterable<Reward> all){
        ArrayList<Reward> arrayList = new ArrayList<>();
        all.forEach(arrayList::add);
        return arrayList;
    }

}
