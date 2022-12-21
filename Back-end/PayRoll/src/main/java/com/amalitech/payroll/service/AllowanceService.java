package com.amalitech.payroll.service;

import com.amalitech.payroll.component.AllowanceComponent;
import com.amalitech.payroll.contracts.AllowanceContract;
import com.amalitech.payroll.model.Allowance;
import com.amalitech.payroll.repository.AllowanceRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class AllowanceService implements AllowanceContract {
    final AllowanceRepository allowanceRepository;

    @Override
    public ResponseData getAllAllowance() {
        final Iterable<Allowance> all = allowanceRepository.findAll();
        ArrayList<String> arrayList = new ArrayList<>();
        all.forEach(value->arrayList.add(value.getType()));
        return new ResponseData(Constants.OK,Constants.SUCCESS,arrayList);
    }

    @Override
    public ResponseData deleteAllowanceByName(String name) {
        return null;
    }

    @Override
    public ResponseData addAllowance(Allowance allowance) {
        return new ResponseData(Constants.OK,Constants.SUCCESS,allowanceRepository.save(allowance));
    }


}
