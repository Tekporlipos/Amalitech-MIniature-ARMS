package com.amalitech.payroll.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Map;
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private Long batch;
    private String payRollCode;
    private String userId;
    private String firstName;
    private String lastName;
    private String otherName;
    private String tell;
    private String email;
    private String gender;
    private String profile;
    private String createdAt;


    public Employee convert(Map<String,Object> data,String month){
        setPayRollCode(month);
        setUserId(String.valueOf(data.get("user_id")));
        setFirstName(String.valueOf(data.get("first_name")));
        setLastName(String.valueOf(data.get("last_name")));
        setOtherName(String.valueOf(data.get("other_names")));
        setProfile(String.valueOf(data.get("profile")));
        setEmail(String.valueOf(data.get("email")));
        setGender(String.valueOf(data.get("gender")));
        setTell(String.valueOf(data.get("tell")));
        setCreatedAt(new Date().toString());
        return this;
    }
}