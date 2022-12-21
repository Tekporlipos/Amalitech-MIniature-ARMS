package com.amalitech.payroll.controller;


import com.amalitech.payroll.component.AllowanceComponent;
import com.amalitech.payroll.model.Allowance;
import com.amalitech.payroll.service.AllowanceService;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AllowanceController {
   final AllowanceService allowanceService;

   @GetMapping("")
    public ResponseData getAllowance(){
        return allowanceService.getAllAllowance();
    }

    @DeleteMapping("/{delete}")
    public ResponseData DeleteAllowance(@PathVariable("delete") String delete){
       return allowanceService.deleteAllowanceByName(delete);
    }

    @PostMapping("/")
    public ResponseData addAllowance(@RequestParam Allowance allowance){
       return allowanceService.addAllowance(allowance);
    };
}
