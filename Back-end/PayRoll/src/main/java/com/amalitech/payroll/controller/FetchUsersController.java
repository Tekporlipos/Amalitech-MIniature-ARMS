package com.amalitech.payroll.controller;


import com.amalitech.payroll.service.FetchUserService;
import com.amalitech.payroll.utils.ResponseData;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/payroll")
@RequiredArgsConstructor
public class FetchUsersController {

    final FetchUserService fetchUserService;

    @GetMapping("")
    public ResponseData getAllPayroll(){
        return  fetchUserService.getAllPayRolls();
    }

    @GetMapping("/generate")
    public Object getUsers(@RequestHeader("authorization") String token) throws IOException, ParseException {
        Object allUsers = fetchUserService.getAllUsers(token);
        return  allUsers;
    }

    @GetMapping("/user")
    public Object getPayrollByUserId(@RequestHeader("authorization") String token) throws IOException, ParseException {
        return  fetchUserService.getPayRollByUserId(token);
    }


}
