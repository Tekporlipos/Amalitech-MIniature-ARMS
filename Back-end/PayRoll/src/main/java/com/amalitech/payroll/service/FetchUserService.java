package com.amalitech.payroll.service;


import com.amalitech.payroll.model.Employee;
import com.amalitech.payroll.model.RewardAllocation;
import com.amalitech.payroll.repository.EmployeeRepository;
import com.amalitech.payroll.repository.RewardAllocationRepository;
import com.amalitech.payroll.utils.Constants;
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
        final ArrayList<Map<String, Object>> allEmployee = (ArrayList<Map<String, Object>>) getData(auth);
        ArrayList<Employee> employees = new ArrayList<>();
        for(Map<String, Object> map : allEmployee){
            employees.add(new Employee().convert(map,getReward("allowance",String.valueOf(map.get("user_id"))),getReward("bonus",String.valueOf(map.get("user_id")))));
        }
        savePayRolls(employees);
        return new ResponseData(Constants.OK,Constants.SUCCESS,employees);
    }

    public  ResponseData getPayRollByUserId(String token) throws IOException, ParseException {
//        final Map<String, Object> user = (Map<String, Object>) getData(token);
        final Optional<Employee> byUserId = employeeRepository.findByUserId("8b977731-3887-4801-88f7-c8f81085a83f");
        return new ResponseData(Constants.OK,Constants.SUCCESS, byUserId.isPresent()? byUserId.get(): Arrays.asList());
    };



    public Object getData(String auth) throws IOException, ParseException {
//        String stream = Methods.stream(Constants.URL + "payroll", REQUESTS.GET.name(), auth);
        JSONParser parser = new JSONParser();
//        return parser.parse(stream);
        return parser.parse("[\n" +
                "    {\n" +
                "        \"bank_branch\": \"KNUST\",\n" +
                "        \"account_number\": \"00001234566\",\n" +
                "        \"role\": \"admin\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"profile\": \"C:\\\\Users\\\\JohnDzikunu\\\\Documents\\\\My Developments\\\\Amalitech\\\\PROJECTS\\\\Amalitech-MIniature-ARMS\\\\Back-end\\\\ARMS\\\\public\\\\profiles\\\\2022-12-21 13-25-50WIN_20221221_12_22_36_Pro.jpg\",\n" +
                "        \"tell\": \"054371591\",\n" +
                "        \"last_name\": \"Dzikunu\",\n" +
                "        \"other_names\": null,\n" +
                "        \"hire_date\": \"2022-12-20T16:01:17\",\n" +
                "        \"salary\": \"2500.00\",\n" +
                "        \"user_id\": \"8b977731-3887-4801-88f7-c8f81085a83f\",\n" +
                "        \"account_name\": \"John Dzikunu\",\n" +
                "        \"bank_name\": \"CalBank\",\n" +
                "        \"department\": \"service center\",\n" +
                "        \"first_name\": \"John\",\n" +
                "        \"email\": \"johndzikunu36@gmail.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"bank_branch\": \"KNUST\",\n" +
                "        \"account_number\": \"00001234566\",\n" +
                "        \"role\": \"employee\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"profile\": null,\n" +
                "        \"tell\": \"054371591\",\n" +
                "        \"last_name\": \"Dzikunu\",\n" +
                "        \"other_names\": null,\n" +
                "        \"hire_date\": \"2022-12-20T16:01:17\",\n" +
                "        \"salary\": \"2500.00\",\n" +
                "        \"user_id\": \"3dae3eb9-6a43-4e4c-816b-5b3ea354dd3d\",\n" +
                "        \"account_name\": \"John Dzikunu\",\n" +
                "        \"bank_name\": \"CalBank\",\n" +
                "        \"department\": \"service center\",\n" +
                "        \"first_name\": \"John\",\n" +
                "        \"email\": \"johndzikunu1213@gmail.com\"\n" +
                "    }\n" +
                "]");
    }


  public  ResponseData getAllPayRolls(){
        final Iterable<Employee> all = employeeRepository.findAll();
        ArrayList<Employee> arrayList = new ArrayList<>();
        all.forEach(value->arrayList.add(value));
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
