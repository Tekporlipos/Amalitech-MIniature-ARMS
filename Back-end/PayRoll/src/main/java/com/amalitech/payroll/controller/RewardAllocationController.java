package com.amalitech.payroll.controller;

import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.service.RewardAllocationService;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/allocation")
public class RewardAllocationController {
   final RewardAllocationService allocationService;
   @GetMapping("")
    public ResponseData getRewardAllocation(){
        return allocationService.getAllReward();
    }
    @GetMapping("/{type}")
    public ResponseData getRewardByType( @PathVariable String type){
        return allocationService.getAllRewardByType(type);
    }
    @PostMapping("")
    public ResponseData addReward(@RequestBody RewardAllocation allowance){
       return allocationService.addRewardAllocation(allowance);
    }

    @DeleteMapping("")
    public ResponseData deleteReward(@RequestBody String name){
        return allocationService.deleteRewardByName(name);
    }
}
