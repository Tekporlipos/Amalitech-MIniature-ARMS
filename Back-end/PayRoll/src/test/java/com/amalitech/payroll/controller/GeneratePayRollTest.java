package com.amalitech.payroll.controller;

import com.amalitech.payroll.filters.AuthorizationFilter;
import com.amalitech.payroll.service.FetchUserService;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import org.json.simple.parser.ParseException;
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

import java.io.IOException;
import java.util.Optional;

@Configuration
@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("test")
class GeneratePayRollTest {

 @Autowired
 GeneratePayRoll generatePayRoll;

 @MockBean
 FetchUserService fetchUserService;
 @MockBean
 AuthorizationFilter authorizationFilter;

    @Test
    void getAllPayroll() {
     Mockito.when(authorizationFilter.
             isAdmin(Mockito.anyString())).
             thenReturn(true);
     Mockito.when(fetchUserService
             .getAllPayRolls(Mockito.any(),
                     Mockito.any(),
                     Mockito.any(),
                     Mockito.any()))
             .thenReturn(new ResponseData(Constants.OK,
                     Constants.SUCCESS,"Test Data"));


     //If user is authenticated and is admin
     Assertions.assertEquals(generatePayRoll
             .getAllPayroll("token",
                     Optional.empty(),
                     Optional.empty(),
                     Optional.empty(),
                     Optional.empty()),
             ResponseEntity
                     .ok(new ResponseData(Constants.OK,
                     Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(generatePayRoll
                        .getAllPayroll("token",
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                                Constants.UNAUTHORIZED,Constants.UN_AUTH)));
    }


    @Test
    void searchAllPayroll() {
     Mockito.when(authorizationFilter.
                     isAdmin(Mockito.anyString())).
             thenReturn(true);
     Mockito.when(fetchUserService
                     .searchAllPayRolls(Mockito.any(),
                             Mockito.any(),
                             Mockito.any(),
                             Mockito.any(),
                             Mockito.any()))
             .thenReturn(new ResponseData(Constants.OK,
                     Constants.SUCCESS,"Test Data"));
     Assertions.assertEquals(generatePayRoll
                     .searchAllPayroll("token",
                             Optional.empty(),
                             Optional.empty(),
                             Optional.empty(),
                             Optional.empty(),
                             Optional.empty()),
             ResponseEntity
                     .ok(new ResponseData(Constants.OK,
                             Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(generatePayRoll
                        .getAllPayroll("token",
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));
    }


    @Test
    void getUsers() throws IOException, ParseException {
     Mockito.when(authorizationFilter.
                     isAdmin(Mockito.anyString())).
             thenReturn(true);
     Mockito.when(fetchUserService
                     .getAllUsers(Mockito.any(),
                             Mockito.any()))
             .thenReturn(new ResponseData(Constants.OK,
                     Constants.SUCCESS,"Test Data"));
     Assertions.assertEquals(generatePayRoll
                     .getUsers("token",Optional.empty()),
             ResponseEntity
                     .ok(new ResponseData(Constants.OK,
                             Constants.SUCCESS,"Test Data")));

        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(generatePayRoll
                        .getAllPayroll("token",
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,Constants.UN_AUTH)));

    }

    @Test
    void getPayrollByUserId() throws IOException, ParseException {
     Mockito.when(authorizationFilter.
                     isAuth(Mockito.anyString())).
             thenReturn(true);
     Mockito.when(fetchUserService
                     .getPayRollByUserId(Mockito.any(),
                             Mockito.any()))
             .thenReturn(new ResponseData(Constants.OK,
                     Constants.SUCCESS,"Test Data"));
     Assertions.assertEquals(generatePayRoll
                     .getPayrollByUserId("token",
                             Optional.empty()),
             ResponseEntity
                     .ok(new ResponseData(Constants.OK,
                             Constants.SUCCESS,"Test Data")));



        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(generatePayRoll
                        .getAllPayroll("token",
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,"unauthorized")));

    }

    @Test
    void getAllPayCode() {
     Mockito.when(authorizationFilter.
                     isAuth(Mockito.anyString())).
             thenReturn(true);
     Mockito.when(fetchUserService
                     .getPayCode())
             .thenReturn(new ResponseData(Constants.OK,
                     Constants.SUCCESS,"Test Data"));
     Assertions.assertEquals(generatePayRoll
                     .getAllPayCode("token"),
             ResponseEntity
                     .ok(new ResponseData(Constants.OK,
                             Constants.SUCCESS,"Test Data")));



        //If user is not authenticated and is admin
        Mockito.when(authorizationFilter.
                        isAdmin(Mockito.anyString())).
                thenReturn(false);
        Assertions.assertEquals(generatePayRoll
                        .getAllPayroll("token",
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()),
                ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,
                        Constants.UNAUTHORIZED,"unauthorized")));

    }
}