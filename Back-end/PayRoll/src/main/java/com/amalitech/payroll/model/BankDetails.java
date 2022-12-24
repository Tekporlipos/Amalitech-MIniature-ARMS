package com.amalitech.payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BankDetails {


    @Id
    @GeneratedValue
    private Long id;

    private String user_id;
    private String bankBranch;
    private String accountNumber;
    private String accountName;
    private String bankName;
}
