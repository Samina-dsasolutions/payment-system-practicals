package com.hibernatepractice.paymentsystem.controller;


import com.hibernatepractice.paymentsystem.service.InterestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.hibernatepractice.paymentsystem.model.AutoDebitRequest;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final InterestService interestService;

    public PaymentController(InterestService interestService) {
        this.interestService = interestService;
    }

    @PostMapping("/calculate-interest")
    public BigDecimal getInterest(@Valid @RequestBody AutoDebitRequest request) {
        // Simulating 1 day of interest for testing
        return interestService.calculate(new BigDecimal("100.00"), 1);
    }
}