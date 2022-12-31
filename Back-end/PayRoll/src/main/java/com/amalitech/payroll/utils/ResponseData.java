package com.amalitech.payroll.utils;

import io.swagger.annotations.ApiModelProperty;

public record ResponseData(@ApiModelProperty(value = "Status message") String status, @ApiModelProperty(value = "Status code")  Integer code,@ApiModelProperty(value = "Request data")  Object data) {
}