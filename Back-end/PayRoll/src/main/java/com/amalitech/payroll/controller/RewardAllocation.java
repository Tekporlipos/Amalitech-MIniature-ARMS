package com.amalitech.payroll.controller;

import com.amalitech.payroll.filters.AuthorizationFilter;
import com.amalitech.payroll.model.RewardAllocationDTO;
import com.amalitech.payroll.service.RewardAllocationService;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/allocation")
@Api(value = "Reward Allocation")
public class RewardAllocation {
   final RewardAllocationService allocationService;
    final AuthorizationFilter authorizationFilter;
   @GetMapping("")
   @ApiOperation(value = "Get all reward allocation")
    public ResponseEntity<ResponseData> getRewardAllocation(@RequestHeader("authorization") String token){
       if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
       return ResponseEntity.ok(allocationService.getAllReward());
    }


    @GetMapping("/{userId}")
    @ApiOperation(value = "Get all reward allocation by reward type")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "department",name = "month", value = "Optional query parameter of the department of the employee", paramType = "Query"),
                    @ApiImplicitParam(dataType = "type" ,value = "Optional query parameter of the the reward type", paramType = "Query")}
    )
    public ResponseEntity<ResponseData> getRewardByType(@RequestHeader("authorization") String token,
                                         @PathVariable String userId,
                                         @RequestParam("department") Optional<String> department,
                                         @RequestParam("type") Optional<String> type){
        if (!authorizationFilter.isAuth(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,"Unauthenticated."));
        return ResponseEntity.ok(allocationService.getAllRewardByType(userId,type.orElse(""), department.orElse("")));
    }

    @PostMapping("")
    @ApiOperation(value = "Assign a reward to an employee")
    public ResponseEntity<ResponseData> addReward(@RequestBody RewardAllocationDTO allowance, @RequestHeader("authorization") String token){
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return ResponseEntity.ok(allocationService.addRewardAllocation(allowance));
    }

    @DeleteMapping("/{rid}")
    @ApiOperation(value = "Delete reward from an employee")
    @ApiImplicitParam(dataType = "Long",name = "rid",required = true, value = "Path parameter of the reward allocated id you want to delete", paramType = "path")
    public ResponseEntity<ResponseData> deleteReward(@RequestHeader("authorization") String token, @PathVariable Long rid){
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return ResponseEntity.ok(allocationService.deleteRewardById(rid));
    }
}
