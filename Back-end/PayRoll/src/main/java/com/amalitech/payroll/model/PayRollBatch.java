package com.amalitech.payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PayRollBatch {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
}
