package com.amalitech.payroll.service;


import com.amalitech.payroll.model.Employee;
import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.repository.EmployeeRepository;
import com.amalitech.payroll.repository.RewardAllocationRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.Methods;
import com.amalitech.payroll.utils.REQUESTS;
import com.amalitech.payroll.utils.ResponseData;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FetchUserService {

    final RewardAllocationRepository repository;
    final EmployeeRepository employeeRepository;

    public ResponseData getAllUsers(String auth) throws IOException, ParseException {
        final ArrayList<Map<String, Object>> allEmployee = (ArrayList<Map<String, Object>>) getData(auth,"payroll");
        ArrayList<Employee> employees = new ArrayList<>();
        for(Map<String, Object> map : allEmployee){
            employees.add(new Employee().convert(map,getReward("allowance",String.valueOf(map.get("user_id"))),getReward("bonus",String.valueOf(map.get("user_id")))));
        }
        savePayRolls(employees);
        return new ResponseData(Constants.OK,Constants.SUCCESS,employees);
    }

    public  ResponseData getPayRollByUserId(String token) throws IOException, ParseException {
        final Map<String, Object> user = (Map<String, Object>) getData(token,"user");
        final Optional<Employee> byUserId = employeeRepository.findByUserId(String.valueOf(user.get("user_id")));
        return new ResponseData(Constants.OK,Constants.SUCCESS, byUserId.isPresent()? byUserId.get(): Arrays.asList());
    };



    public Object getData(String auth, String path) throws IOException, ParseException {
        String stream = Methods.stream(Constants.URL + path, REQUESTS.GET.name(), auth);
        JSONParser parser = new JSONParser();
        return parser.parse(stream);
    }


  public  ResponseData getAllPayRolls(){
        final Iterable<Employee> all = employeeRepository.findAll();
        ArrayList<Employee> arrayList = new ArrayList<>();
        all.forEach(arrayList::add);
        return new ResponseData(Constants.OK,Constants.SUCCESS,arrayList);
    }

    void savePayRolls(ArrayList<Employee> employees){
        new Thread(() -> {
            final Calendar instance = Calendar.getInstance();
            employeeRepository.deleteAllByPayRollCodeEquals(instance.get(Calendar.YEAR)+""+instance.get(Calendar.MONTH));
            employeeRepository.saveAll(employees);
        }).start();
    }



    Double getReward(String type, String userId){
        Double reward = 0.0;
        for (RewardAllocation next : repository.findAllByTypeAndUserId(type, userId)) {
            reward += next.getAmount();
        }
        return  reward;
    }

}
