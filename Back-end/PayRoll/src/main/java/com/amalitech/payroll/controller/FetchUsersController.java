package com.amalitech.payroll.controller;


import com.amalitech.payroll.service.FetchUserService;
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
@RequestMapping("/fetch")
@RequiredArgsConstructor
public class FetchUsersController {

    final FetchUserService fetchUserService;
    @GetMapping("")
    public Object getUsers(@RequestHeader("authorization") String token) throws IOException, ParseException {
        Object allUsers = fetchUserService.getAllEmployee(token);
        return  allUsers;
    }

}
