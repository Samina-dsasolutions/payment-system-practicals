package com.hibernatepractice.paymentsystem.service;


import com.hibernatepractice.paymentsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BatchOptimizationService {

    @Autowired
    private AccountRepository accountRepository;

    public int processLargeScaleInterest(BigDecimal rate) {
        // This single call handles tens of thousands of records efficiently
        return accountRepository.bulkUpdateInterest(rate);
    }
}