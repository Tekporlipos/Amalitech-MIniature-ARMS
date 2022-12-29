package com.amalitech.payroll.controller;


import com.amalitech.payroll.model.Reward;
import com.amalitech.payroll.service.RewardService;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reward")
public class RewardController {
   final RewardService allowanceService;

   @GetMapping("")
    public ResponseData getReward(){
        return allowanceService.getAllReward();
    }

    @GetMapping("/{type}")
    public ResponseData getRewardByType( @PathVariable String type){
        return allowanceService.getAllRewardByType(type);
    }

    @PostMapping("")
    public ResponseData addReward(@RequestBody Reward allowance){
       return allowanceService.addReward(allowance);
    }

    @DeleteMapping("")
    public ResponseData deleteReward(@RequestBody String name){
        return allowanceService.deleteRewardByName(name);
    }
}
