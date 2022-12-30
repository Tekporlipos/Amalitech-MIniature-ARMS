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
    public ResponseData getUsers(@RequestHeader("authorization") String token) throws IOException, ParseException {
        return fetchUserService.getAllUsers(token);
    }

    @GetMapping("/user")
    public ResponseData getPayrollByUserId(@RequestHeader("authorization") String token,@RequestParam("month") Optional<String> month) throws IOException, ParseException {
        return  fetchUserService.getPayRollByUserId(token,month);
    }
    @GetMapping("/paycode")
    public ResponseData getAllPayCode(@RequestHeader("authorization") String token){
        return  fetchUserService.getPayCode(token);
    }


}
