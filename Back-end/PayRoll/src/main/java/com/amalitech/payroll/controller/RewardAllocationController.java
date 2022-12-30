package com.amalitech.payroll.controller;

import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.service.RewardAllocationService;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/allocation")
public class RewardAllocationController {
   final RewardAllocationService allocationService;
   @GetMapping("")
    public ResponseData getRewardAllocation(){
        return allocationService.getAllReward();
    }


    @GetMapping("/{userId}")
    public ResponseData getRewardByType( @PathVariable String userId,
                                         @RequestParam("department") Optional<String> department,
                                         @RequestParam("type") Optional<String> type){
        return allocationService.getAllRewardByType(userId,type.orElse(""), department.orElse(""));
    }
    @PostMapping("")
    public ResponseData addReward(@RequestBody RewardAllocation allowance){
       return allocationService.addRewardAllocation(allowance);
    }

    @DeleteMapping("/{uid}")
    public ResponseData deleteReward(@PathVariable String uid){
        return allocationService.deleteRewardById(UUID.fromString(uid));
    }
}
