package com.amalitech.payroll.repository;

import com.amalitech.payroll.model.PayRollBatch;
import org.springframework.data.repository.CrudRepository;

public interface BatchRepository extends CrudRepository<PayRollBatch , Long> {

    long countByType(String type);
}
