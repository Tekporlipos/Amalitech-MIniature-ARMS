package com.amalitech.payroll.controller;

import com.amalitech.payroll.filters.AuthorizationFilter;
import com.amalitech.payroll.service.RewardAllocationService;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@Profile("test")
@Configuration
class RewardAllocationTest {

    @Autowired
    RewardAllocation rewardAllocation;

    @MockBean
    RewardAllocationService rewardAllocationService;
    @MockBean
    AuthorizationFilter authorizationFilter;

    @Test
    void getRewardAllocationTest() {
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(true);

        Mockito.when(rewardAllocationService
                        .getAllReward())
                .thenReturn(new ResponseData(Constants.OK,
                        Constants.SUCCESS,"Test Data"));


        //If user is authenticated and is admin
        Assertions.assertEquals(rewardAllocation
                        .getRewardAllocation("token"),
                ResponseEntity
                        .ok(new ResponseData(Constants.OK,
                                Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);

        Assertions.assertEquals(rewardAllocation
                        .getRewardAllocation("token"),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));
    }

    @Test
    void getRewardByType() {
        Mockito.when(authorizationFilter.
                        isAuth(Mockito.anyString())).
                thenReturn(true);

        Mockito.when(rewardAllocationService
                        .getAllRewardByType(
                                Mockito.anyString(),
                                Mockito.any(),
                                Mockito.any()))
                .thenReturn(new ResponseData(Constants.OK,
                        Constants.SUCCESS,"Test Data"));


        //If user is authenticated and is admin
        Assertions.assertEquals(rewardAllocation
                        .getRewardByType("token",
                                "userid",
                                Optional.empty(),
                                Optional.empty()),
                ResponseEntity
                        .ok(new ResponseData(Constants.OK,
                                Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAuth(Mockito.anyString())).
                thenReturn(false);

        Assertions.assertEquals(rewardAllocation
                        .getRewardByType("token",
                                null,
                                Optional.empty(),
                                Optional.empty()),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,"Unauthenticated.")));
         }

    @Test
    void addReward() {
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(true);

        Mockito.when(rewardAllocationService
                        .addRewardAllocation(Mockito.any()))
                .thenReturn(new ResponseData(Constants.OK,
                        Constants.SUCCESS,"Test Data"));


        //If user is authenticated and is admin
        Assertions.assertEquals(rewardAllocation
                        .addReward(Mockito.any(),
                                "Token"),
                ResponseEntity
                        .ok(new ResponseData(Constants.OK,
                                Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);

        Assertions.assertEquals(rewardAllocation
                        .getRewardAllocation("token"),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));
    }

    @Test
    void deleteReward() {
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(true);

        Mockito.when(rewardAllocationService
                        .deleteRewardById(Mockito.any()))
                .thenReturn(new ResponseData(Constants.OK,
                        Constants.SUCCESS,"Test Data"));


        //If user is authenticated and is admin
        Assertions.assertEquals(rewardAllocation
                        .deleteReward("Token",Mockito.any()),
                ResponseEntity
                        .ok(new ResponseData(Constants.OK,
                                Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);

        Assertions.assertEquals(rewardAllocation
                        .getRewardAllocation("token"),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));
    }
}