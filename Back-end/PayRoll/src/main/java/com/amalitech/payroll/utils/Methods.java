package com.amalitech.payroll.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Methods {


    private Methods() {}

    public static String stream(String path, String method, String auth) throws IOException {
        // Sending get request
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization","Bearer "+auth);
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod(method);
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;
        StringBuilder response = new StringBuilder();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();
        return response.toString();
    }



}
