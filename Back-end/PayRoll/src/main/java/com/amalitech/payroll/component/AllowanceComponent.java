package com.amalitech.payroll.component;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AllowanceComponent {
    private String name, description;
}
