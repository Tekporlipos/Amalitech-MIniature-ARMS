package com.amalitech.payroll.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Methods<T> {
    public static String stream(String path, String method, String auth) throws IOException, ParseException {
        // Sending get request
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization","Bearer "+auth);
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod(method);
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();
        return response.toString();
    }



}
