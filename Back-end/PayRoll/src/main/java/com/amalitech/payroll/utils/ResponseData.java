package com.amalitech.payroll.utils;

public record ResponseData(String status, Integer code, Object data) {
}