package com.hibernatepractice.paymentsystem.service;



import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class InterestService {
    // Simple 5% daily interest for demonstration
    private static final BigDecimal RATE = new BigDecimal("0.05");

    public BigDecimal calculate(BigDecimal amount, int days) {
        return amount.multiply(RATE).multiply(new BigDecimal(days));
    }
}