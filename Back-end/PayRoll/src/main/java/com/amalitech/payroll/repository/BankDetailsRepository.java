package com.amalitech.payroll.repository;


import com.amalitech.payroll.model.BankDetails;
import com.amalitech.payroll.model.Reward;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BankDetailsRepository extends CrudRepository<BankDetails, Long> {
}
