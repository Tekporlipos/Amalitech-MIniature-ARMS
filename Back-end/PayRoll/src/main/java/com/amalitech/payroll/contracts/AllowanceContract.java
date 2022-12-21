package com.amalitech.payroll.contracts;

import com.amalitech.payroll.model.Allowance;
import com.amalitech.payroll.utils.ResponseData;


public interface AllowanceContract {
    ResponseData getAllAllowance();
    ResponseData deleteAllowanceByName(String name);
    ResponseData addAllowance(Allowance allowance);
}
