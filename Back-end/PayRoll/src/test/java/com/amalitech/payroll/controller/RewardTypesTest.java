package com.amalitech.payroll.controller;

import com.amalitech.payroll.filters.AuthorizationFilter;
import com.amalitech.payroll.model.RewardDTO;
import com.amalitech.payroll.service.FetchUserService;
import com.amalitech.payroll.service.RewardAllocationService;
import com.amalitech.payroll.service.RewardService;
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
class RewardTypesTest {


    @Autowired
    RewardTypes rewardTypes;

    @MockBean
    RewardService rewardService;
    @MockBean
    AuthorizationFilter authorizationFilter;

    @Test
    void getRewardTest() {
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(true);
        Mockito.when(rewardService
                        .getAllRewardByType(Mockito.any()))
                .thenReturn(new ResponseData(Constants.OK,
                        Constants.SUCCESS,"Test Data"));

        //If user is authenticated and is admin
        Assertions.assertEquals(rewardTypes
                        .getRewardByType("token",
                                "type"),
                ResponseEntity
                        .ok(new ResponseData(Constants.OK,
                                Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(rewardTypes
                        .getRewardByType("token",
                "type"),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));

    }

    @Test
    void getRewardByType() {
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(true);
        Mockito.when(rewardService
                        .getAllRewardByType(Mockito.any()))
                .thenReturn(new ResponseData(Constants.OK,
                        Constants.SUCCESS,"Test Data"));

        //If user is authenticated and is admin
        Assertions.assertEquals(rewardTypes
                        .getRewardByType("token",
                                "type"),
                ResponseEntity
                        .ok(new ResponseData(Constants.OK,
                                Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(rewardTypes
                        .getRewardByType("token",
                                "type"),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));
          }

    @Test
    void addReward() {
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(true);
        Mockito.when(rewardService
                        .addReward(Mockito.any()))
                .thenReturn(new ResponseData(Constants.OK,
                        Constants.SUCCESS,"Test Data"));

        //If user is authenticated and is admin
        Assertions.assertEquals(rewardTypes
                        .addReward("token",
                                null),
                ResponseEntity
                        .ok(new ResponseData(Constants.OK,
                                Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(rewardTypes
                        .addReward("token",
                                null),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));
    }

    @Test
    void deleteReward() {
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(true);
        Mockito.when(rewardService
                        .deleteRewardByName(Mockito.any()))
                .thenReturn(new ResponseData(Constants.OK,
                        Constants.SUCCESS,"Test Data"));

        //If user is authenticated and is admin
        Assertions.assertEquals(rewardTypes
                        .deleteReward("token",
                                new RewardDTO()),
                ResponseEntity
                        .ok(new ResponseData(Constants.OK,
                                Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(rewardTypes
                        .deleteReward("token",
                                null),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));
        }
}