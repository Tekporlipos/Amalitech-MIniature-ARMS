package com.amalitech.payroll.controller;


import com.amalitech.payroll.service.FetchUserService;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/payroll")
@RequiredArgsConstructor
public class FetchUsersController {

    final FetchUserService fetchUserService;

    @GetMapping("")
    public ResponseData getAllPayroll(@RequestParam("month") Optional<String> month,
                                      @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("limit") Optional<Integer> limit){
        return  fetchUserService.getAllPayRolls(month,page,limit);
    }

    @GetMapping("/generate")
    public Object getUsers(@RequestHeader("authorization") String token) throws IOException, ParseException {
        return fetchUserService.getAllUsers(token);
    }

    @GetMapping("/user")
    public Object getPayrollByUserId(@RequestHeader("authorization") String token) throws IOException, ParseException {
        return  fetchUserService.getPayRollByUserId(token);
    }


}
