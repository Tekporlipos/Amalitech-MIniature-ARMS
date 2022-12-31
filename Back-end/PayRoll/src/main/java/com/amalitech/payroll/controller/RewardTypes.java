package com.amalitech.payroll.controller;


import com.amalitech.payroll.filters.AuthorizationFilter;
import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.model.RewardDTO;
import com.amalitech.payroll.service.RewardService;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reward")
@Api(value = "Add get and delete Reward types")
public class RewardTypes {
   final RewardService allowanceService;
    final AuthorizationFilter authorizationFilter;
    @ApiOperation(value = "Get all reward types")
   @GetMapping("")
    public ResponseEntity<ResponseData> getReward(@RequestHeader("authorization") String token){
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return ResponseEntity.ok(allowanceService.getAllReward());
    }

    @ApiOperation(value = "Get all reward types by type")
    @GetMapping("/{type}")
    @ApiImplicitParam(dataType = "Long",name = "type",required = true, value = "Path parameter of the reward type", paramType = "path")
    public ResponseEntity<ResponseData> getRewardByType(@RequestHeader("authorization") String token, @PathVariable String type){
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return ResponseEntity.ok(allowanceService.getAllRewardByType(type));
    }

    @PostMapping("")
    @ApiOperation(value = "Add reward type to reward types")
    public ResponseEntity<ResponseData> addReward(@RequestHeader("authorization") String token,@RequestBody RewardDTO rewardDTO){
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return ResponseEntity.ok(allowanceService.addReward(rewardDTO));
    }

    @ApiOperation(value = "Delete reward type by reward entity")
    @DeleteMapping("")
    public ResponseEntity<ResponseData> deleteReward(@RequestHeader("authorization") String token,@RequestBody RewardDTO name){
        if (!authorizationFilter.isAdmin(token))return ResponseEntity.unprocessableEntity().body(new ResponseData(Constants.BAD,Constants.UNAUTHORIZED,Constants.UN_AUTH));
        return ResponseEntity.ok(allowanceService.deleteRewardByName(name.getName()));
    }
}
