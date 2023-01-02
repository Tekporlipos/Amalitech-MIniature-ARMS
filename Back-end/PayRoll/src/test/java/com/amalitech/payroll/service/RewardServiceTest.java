package com.amalitech.payroll.service;

import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.repository.RewardRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("test")
class RewardServiceTest {
    @MockBean
    RewardRepository rewardRepository;

    @SpyBean
    RewardService rewardService;

    @Test
    void getAllRewardByType() {
        Reward reward = new Reward();
        reward.setType("bonus");
        reward.setDescription("the bonus description");
        reward.setName("signup bonus");
        Iterable<Reward> rewardAllocations = IterableUtil.iterable(reward);
        Mockito.when(rewardRepository.findByType(Mockito.anyString())).thenReturn(rewardAllocations);
        Mockito.doReturn(List.of(rewardService)).when(rewardService).convertArray(Mockito.any());
        Assertions.assertEquals(rewardService.getAllRewardByType("bonus"),new ResponseData(Constants.OK,Constants.SUCCESS, List.of(rewardService)));
    }

    @Test
    void convertArray() {
        Reward reward = new Reward();
        reward.setType("bonus");
        reward.setDescription("the bonus description");
        reward.setName("signup bonus");
        Iterable<Reward> rewardAllocations = IterableUtil.iterable(reward);
        Assertions.assertEquals(rewardService.convertArray(rewardAllocations),List.of(reward));
    }
}