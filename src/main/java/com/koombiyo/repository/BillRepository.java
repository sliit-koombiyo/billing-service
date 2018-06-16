package com.koombiyo.repository;

import com.koombiyo.models.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Damma on 12-Jun-18.
 */
public interface BillRepository extends MongoRepository<Bill, String> {
    public Bill findByPatient(String patient);
}
