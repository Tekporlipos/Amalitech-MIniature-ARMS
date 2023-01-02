package com.amalitech.payroll.service;


import com.amalitech.payroll.model.*;
import com.amalitech.payroll.repository.BankDetailsRepository;
import com.amalitech.payroll.repository.BatchRepository;
import com.amalitech.payroll.repository.EmployeeRepository;
import com.amalitech.payroll.repository.RewardAllocationRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.Methods;
import com.amalitech.payroll.utils.REQUESTS;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FetchUserService {

    final RewardAllocationRepository repository;
    final EmployeeRepository employeeRepository;
    final BatchRepository batchRepository;
    final BankDetailsRepository bankDetailsRepository;
    Calendar instance = Calendar.getInstance();
    public ResponseData getAllUsers(String auth, Optional<String> month) throws IOException, ParseException {
        String cMonth = month.orElseGet(() -> instance.get(Calendar.YEAR) + "" + instance.get(Calendar.MONTH));
        final ArrayList<Map<String, Object>> allEmployee = (ArrayList<Map<String, Object>>) getData(auth,"payroll");
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<BankDetails> bankDetails = new ArrayList<>();
        for(Map<String, Object> map : allEmployee){
            Employee employee = new Employee().convert(map,cMonth);
            final String filed = "user_id";
            BankDetails bankDetail = new BankDetails().
                    convert(map,
                            getReward("allowance",String.valueOf(map.get(filed)),String.valueOf(map.get("department"))),
                            getReward("bonus",String.valueOf(map.get(filed)),String.valueOf(map.get("department"))),cMonth);
            final long count = batchRepository.countByType(cMonth);
            employee.setBatch(count);
            bankDetail.setBatch(count);
            employees.add(employee);
            bankDetails.add(bankDetail);
        }
        this.savePayRolls(employees,bankDetails,cMonth);
        return new ResponseData(Constants.OK,Constants.SUCCESS,"Pay roll generated successfully");
    }

    public  ResponseData getPayRollByUserId(String token,Optional<String> month) throws IOException, ParseException {
        final Map<String, Object> user = (Map<String, Object>) getData(token,"user");
        String cMonth = month.orElseGet(() -> instance.get(Calendar.YEAR) + "" + instance.get(Calendar.MONTH));
        final long byType = batchRepository.countByType(cMonth);
        final Iterator<Map<String, Object>> userPayroll = employeeRepository.findByPayRollCodeAndBatchAndUserId(cMonth, byType - 1, String.valueOf(user.get("user_id"))).iterator();
        final Optional<Map<String, Object>> byUserId = Optional.ofNullable(userPayroll.hasNext()?userPayroll.next():null);
        return new ResponseData(Constants.OK,Constants.SUCCESS, byUserId.isPresent()? byUserId.get(): List.of());
    }

    public Object getData(String auth, String path) throws IOException, ParseException {
        String stream = Methods.stream(Constants.URL + path, REQUESTS.GET.name(), auth);
        JSONParser parser = new JSONParser();
        return parser.parse(stream);
    }


  public  ResponseData getAllPayRolls(Optional<String> month, Optional<Integer> page, Optional<Integer> limit, Optional<Long> batch){
      String cMonth = month.orElseGet(() -> instance.get(Calendar.YEAR) + "" + instance.get(Calendar.MONTH));
      long byType = batch.orElseGet(() -> batchRepository.countByType(cMonth));
      Long cPage = Long.valueOf(page.orElse(0));
      Long cLimit = Long.valueOf(limit.orElse(10));
      final Iterable<Map<String, Object>> all = employeeRepository.findAllByBatchAndPayCodeWithLimitAndOffSet(cMonth,byType-1,cLimit,cPage*cLimit);
      ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        all.forEach(arrayList::add);
        return new ResponseData(Constants.OK,Constants.SUCCESS,
                Map.of("payroll",arrayList,"page",cPage,"limit",cLimit,"total",
                        employeeRepository.countAllByBatchAndPayRollCode(byType-1,cMonth)));
    }

    void savePayRolls(ArrayList<Employee> employees, ArrayList<BankDetails> bankDetails,String month){
        new Thread(() -> {
            final PayRollBatch payRollBatch = new PayRollBatch();
            payRollBatch.setType(month);
            batchRepository.save(payRollBatch);
            employeeRepository.saveAll(employees);
            bankDetailsRepository.saveAll(bankDetails);
        }).start();
    }

    Double getReward(String type, String userId,String department){
        Double reward = 0.0;
        for (RewardAllocation next : repository.findAllByTypeAndUserId(userId,type.trim().toLowerCase(), department.trim().toLowerCase())) {
            reward += next.getAmount();
        }
        return  reward;
    }

    public ResponseData getPayCode() {
        final Iterable<String> allPayCode = employeeRepository.findAllPayCode();
        ArrayList<String> arrayList = new ArrayList<>();
        allPayCode.forEach(arrayList::add);
       return new ResponseData(Constants.OK,Constants.SUCCESS,arrayList);
    }

    public ResponseData searchAllPayRolls(Optional<String> month, Optional<String> search, Optional<Long> batch, Optional<Integer> page, Optional<Integer> limit) {
        String cMonth = month.orElseGet(() -> instance.get(Calendar.YEAR) + "" + instance.get(Calendar.MONTH));
        Long byType = batch.orElseGet(() -> batchRepository.countByType(cMonth));
        Integer cPage = page.orElse(0);
        Integer cLimit = limit.orElse(10);
        final String cSearch = search.orElse("");
        final Iterable<Map<String, Object>> all = employeeRepository.searchAllByBatchAndPayRollCodeOrFirstNameOrLastNameOrOtherNameWithLimitAndOffSet(byType - 1, cMonth, "%"+cSearch+"%",cPage,cLimit);
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        all.forEach(arrayList::add);
        return new ResponseData(Constants.OK,Constants.SUCCESS,all);
    }
}
