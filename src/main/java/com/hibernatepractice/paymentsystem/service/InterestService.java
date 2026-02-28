package com.hibernatepractice.paymentsystem.service;



import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InterestService {
    // Simple 5% daily interest for demonstration
    private static final BigDecimal RATE = new BigDecimal("0.05");
    private static final BigDecimal MINIMUM_FEE = new BigDecimal("2.00"); // Added complexity

    public BigDecimal calculate(BigDecimal amount, int days) {
        if (days <= 0) return BigDecimal.ZERO;

        // V2: Calculation with a floor (minimum fee)
        BigDecimal interest = amount.multiply(RATE).multiply(new BigDecimal(days));

        // Ensure it doesn't fall below minimum fee and set scale to 2
        return interest.max(MINIMUM_FEE).setScale(2, RoundingMode.HALF_UP);
    }
}