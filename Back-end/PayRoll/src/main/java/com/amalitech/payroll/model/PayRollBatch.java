package com.amalitech.payroll.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class PayRollBatch {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
}
