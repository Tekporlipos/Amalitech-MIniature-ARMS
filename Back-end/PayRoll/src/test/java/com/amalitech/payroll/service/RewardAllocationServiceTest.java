package com.amalitech.payroll.service;

import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.repository.RewardAllocationRepository;
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
class RewardAllocationServiceTest {
    @MockBean
    RewardAllocationRepository repository;
    @SpyBean
    RewardAllocationService rewardAllocationService;
    @Test
    void getAllRewardByType() {
        RewardAllocation rewardAllocation = new RewardAllocation();
        rewardAllocation.setRewardName("Signup bonus");
        rewardAllocation.setUserId("8b977731-3887-4801-88f7-c8f81085a83f");
        rewardAllocation.setId(1L);
        rewardAllocation.setType("bonus");
        rewardAllocation.setAmount(100L);
        rewardAllocation.setStartMonth("202211");
        Iterable<RewardAllocation> rewardAllocations = IterableUtil.iterable(rewardAllocation);
        Mockito.when(repository.findAll())
                .thenReturn(rewardAllocations);
        Mockito.doReturn(List.of(rewardAllocation))
                .when(rewardAllocationService)
                .convertArray(Mockito.any());
        Assertions.assertEquals(rewardAllocationService
                        .getAllReward(),
                new ResponseData(Constants.OK,Constants.SUCCESS,
                        List.of(rewardAllocation)));
    }

    @Test
    void convertArray() {
        RewardAllocation rewardAllocation = new RewardAllocation();
        rewardAllocation.setRewardName("Signup bonus");
        rewardAllocation.setUserId("8b977731-3887-4801-88f7-c8f81085a83f");
        rewardAllocation.setId(1L);
        rewardAllocation.setType("bonus");
        rewardAllocation.setAmount(100L);
        rewardAllocation.setStartMonth("202211");
        Iterable<RewardAllocation> rewardAllocations = IterableUtil.iterable(rewardAllocation);
        Assertions.assertEquals(rewardAllocationService
                .convertArray(rewardAllocations),
                List.of(rewardAllocation));
    }
}