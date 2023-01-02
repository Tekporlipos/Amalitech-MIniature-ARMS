package com.amalitech.payroll.controller;


import com.amalitech.payroll.filters.AuthorizationFilter;
import com.amalitech.payroll.service.FetchUserService;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/payroll")
@RequiredArgsConstructor
@Api(value = "Generate, search and get all the employee payroll")
public class GeneratePayRoll {

    final FetchUserService fetchUserService;
    final AuthorizationFilter authorizationFilter;

    @ApiOperation(value = "Get all payroll of employees")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "String",defaultValue = "202211",name = "month", value = "Optional query parameter to set the month of the payroll result", paramType = "Query"),
                    @ApiImplicitParam(dataType = "Long", name = "batch",value = "Optional query parameter to set the batch of the payroll result", paramType = "Query"),
                    @ApiImplicitParam(dataType = "Long", name = "page", defaultValue = "0", value = "Optional query parameter to set the page of the payroll result", paramType = "Query"),
                    @ApiImplicitParam(dataType = "Long", name = "limit", defaultValue = "10", value = "Optional query parameter to set the limit of the payroll result", paramType = "Query")}
    )
    @GetMapping("")
    public ResponseEntity<ResponseData> getAllPayroll(@RequestHeader("authorization") String token,
                                        @RequestParam("month") Optional<String> month,
                                        @RequestParam("batch") Optional<Long> batch,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("limit") Optional<Integer> limit){
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return  ResponseEntity.ok(fetchUserService.getAllPayRolls(month,page,limit,batch));

    }

    @ApiOperation(value = "Search for employees in payroll of data")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "String",defaultValue = "202211",name = "month", value = "Optional query parameter to set the month of the search result", paramType = "Query"),
                    @ApiImplicitParam(dataType = "Long", name = "batch",value = "Optional query parameter to set the batch of the search result", paramType = "Query"),
                    @ApiImplicitParam(dataType = "Long", name = "page", defaultValue = "0", value = "Optional query parameter to set the page of the search result", paramType = "Query"),
                    @ApiImplicitParam(dataType = "Long", name = "limit", defaultValue = "10", value = "Optional query parameter to set the limit of the search result", paramType = "Query"),
                    @ApiImplicitParam(dataType = "Long", name = "search", required = true, value = "Optional query parameter of the name you are searching for", paramType = "Query")}
    )

    @GetMapping("/search")
    public ResponseEntity<ResponseData> searchAllPayroll(@RequestHeader("authorization") String token,
                                        @RequestParam("month") Optional<String> month,
                                         @RequestParam("batch") Optional<Long> batch,
                                         @RequestParam("page") Optional<Integer> page,
                                         @RequestParam("limit") Optional<Integer> limit,
                                         @RequestParam("search") Optional<String> search){
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return ResponseEntity.ok(fetchUserService.searchAllPayRolls(month,search,batch,page,limit));
    }


    @ApiOperation(value = "Generate payroll for all employees")
    @GetMapping("/generate")
    @ApiImplicitParam(dataType = "String",defaultValue = "202211",name = "month", value = "Optional query parameter to set the month of the payroll you want to generate", paramType = "Query")
    public ResponseEntity<ResponseData> getUsers(@RequestHeader("authorization") String token,@RequestParam("month") Optional<String> month) throws IOException, ParseException {
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return ResponseEntity.ok(fetchUserService.getAllUsers(token,month));
    }

    @ApiOperation(value = "Get payroll for a single employee")
    @GetMapping("/user")
    @ApiImplicitParam(dataType = "String",defaultValue = "202211",name = "month", value = "Optional query parameter to set the month of the payroll you want to get for a particular user", paramType = "Query")
    public ResponseEntity<ResponseData> getPayrollByUserId(@RequestHeader("authorization") String token,@RequestParam("month") Optional<String> month) throws IOException, ParseException {
        if (!authorizationFilter.isAuth(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,"Unauthenticated."));
        return ResponseEntity.ok(fetchUserService.getPayRollByUserId(token,month));
    }

    @ApiOperation(value = "Get payroll months available")
    @GetMapping("/paycode")
    public ResponseEntity<ResponseData> getAllPayCode(@RequestHeader("authorization") String token){
        if (!authorizationFilter.isAuth(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,"Unauthenticated."));
        return ResponseEntity.ok(fetchUserService.getPayCode());
    }


}
