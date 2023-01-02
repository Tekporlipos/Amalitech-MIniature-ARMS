package com.amalitech.payroll.service;

import com.amalitech.payroll.repository.BankDetailsRepository;
import com.amalitech.payroll.repository.BatchRepository;
import com.amalitech.payroll.repository.EmployeeRepository;
import com.amalitech.payroll.repository.RewardAllocationRepository;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.ResponseData;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.IterableUtil;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("test")
class FetchUserServiceTest {
    @MockBean
     RewardAllocationRepository repository;
    @MockBean
     EmployeeRepository employeeRepository;
    @MockBean
     BatchRepository batchRepository;
    @MockBean
     BankDetailsRepository bankDetailsRepository;
    @SpyBean
    FetchUserService fetchUserService;



   public void init(Map<String, Object> map,ArrayList<Map<String, Object>> user){
       map.put("bank_branch","KNUST");
       map.put("account_number","00001234566");
       map.put("role","admin");
       map.put("gender","male");
       map.put("profile","null");
       map.put("tell","054371591");
       map.put("last_name","Dzikunu");
       map.put("other_names","null");
       map.put("hire_date","2022-12-20T16:01:17");
       map.put("salary","2500.00");
       map.put("user_id","8b977731-3887-4801-88f7-c8f81085a83f");
       map.put("account_name","John Dzikunu");
       map.put("bank_name","CalBank");
       map.put("department","service center");
       map.put("first_name","John");
       map.put("email","johndzikunu36@gmail.com");
       map.put("position","Junior associate");
       user.add(map);
   }



    @Test
    void getAllUsers() throws IOException, ParseException {
         ArrayList<Map<String, Object>>  user = new ArrayList<>();
         Map<String, Object> map = new HashMap<>();
         init(map, user);

        Mockito.doReturn(user).when(fetchUserService).getData(Mockito.anyString(),Mockito.any());
        Mockito.doNothing().when(fetchUserService).savePayRolls(Mockito.any(),Mockito.any(),Mockito.any());
        Mockito.doReturn(100.54).when(fetchUserService).getReward(Mockito.any(),Mockito.any(),Mockito.any(),Mockito.anyString());
        Assertions.assertThat(
                fetchUserService.
                        getAllUsers("token",
                                Optional.empty()))
                .isEqualTo(new ResponseData(Constants.OK,Constants.SUCCESS,"Pay roll generated successfully"));

    }

    @Test
    void getPayRollByUserId() throws IOException, ParseException {
        ArrayList<Map<String, Object>>  user = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        init(map, user);
        final Iterable<Map<String, Object>> userIt = IterableUtil.iterable(map);
        Mockito.doReturn(map).when(fetchUserService).getData(Mockito.anyString(),Mockito.any());
        Mockito.when(employeeRepository.findByPayRollCodeAndBatchAndUserId(Mockito.anyString(),
                Mockito.anyLong(),Mockito.anyString())).thenReturn(userIt);
        Mockito.when(batchRepository.countByType(Mockito.anyString())).thenReturn(1L);
        Assertions.assertThat(
                        fetchUserService.
                                getPayRollByUserId("token",
                                        Optional.empty()))
                .isEqualTo(new ResponseData(Constants.OK,Constants.SUCCESS,
                        map));
    }


    @Test
    void getAllPayRolls() {
        ArrayList<Map<String, Object>>  user = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        init(map, user);
        final Iterable<Map<String, Object>> userIt = IterableUtil.iterable(map);
        Mockito.when(batchRepository.countByType(Mockito.anyString())).thenReturn(1L);
        Mockito.when(employeeRepository.findAllByBatchAndPayCodeWithLimitAndOffSet(Mockito.anyString(),
                Mockito.anyLong(),Mockito.anyLong(),Mockito.anyLong())).thenReturn(userIt);
        Mockito.when(employeeRepository.countAllByBatchAndPayRollCode(Mockito.anyLong(),Mockito.anyString())).thenReturn(1L);
        Assertions.assertThat(
                        fetchUserService.
                                getAllPayRolls(
                                        Optional.empty(),
                                        Optional.empty(),
                                        Optional.empty(),
                                        Optional.empty()
                                ))
                .isEqualTo(new ResponseData(Constants.OK,Constants.SUCCESS,
                        Map.of("payroll",user,"page",0L,"limit",10L,"total", 1L)));
    }


    @Test
    void getPayCode() {
        ArrayList<String>  user = new ArrayList<>();
        final String code = "202211";
        user.add(code);
        final Iterable<String> userIt = IterableUtil.iterable(code);
        Mockito.when(employeeRepository.findAllPayCode()).thenReturn(userIt);
        Assertions.assertThat(fetchUserService.getPayCode()).isEqualTo(new ResponseData(Constants.OK,Constants.SUCCESS,user));
    }
}