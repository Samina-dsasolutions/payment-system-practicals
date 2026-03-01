package com.hibernatepractice.paymentsystem.service;


import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import com.hibernatepractice.paymentsystem.repository.AdvancedPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AutoDebitService {

    @Autowired
    private AdvancedPaymentRepository repository;

    @Transactional
    public PaymentTransaction executeAutoDebit(BigDecimal amount) {
        PaymentTransaction tx = new PaymentTransaction();
        tx.setAmount(amount);
        tx.setStatus("INITIATED");

        // Use saveAndFlush to push the record to MySQL immediately.
        // This makes it visible to other database connections or external
        // auditing systems even before this method finishes.
        return repository.saveAndFlush(tx);
    }
}