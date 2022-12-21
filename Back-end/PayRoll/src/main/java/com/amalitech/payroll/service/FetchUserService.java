package com.amalitech.payroll.service;


import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.Methods;
import com.amalitech.payroll.utils.REQUESTS;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Service
public class FetchUserService {
//    public Object getAllUsers() throws IOException, ParseException {
//     return  Methods.stream("");
//    }
    public Object getAllEmployee(String auth) throws IOException, ParseException {
        String stream = Methods.stream(Constants.URL + "payroll", REQUESTS.GET.name(), auth);
        JSONParser parser = new JSONParser();
        return parser.parse(stream);
    }


}
