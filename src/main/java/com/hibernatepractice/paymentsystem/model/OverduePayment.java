package com.hibernatepractice.paymentsystem.model;



// Spring Boot 3 approach (Jakarta) - Required for Java 17+


import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "overdue_payments")
public class OverduePayment {
    @Id
    private String transactionId; // Unique ID for the payment transaction
    private BigDecimal dueAmount; // The principal amount overdue
    private BigDecimal interestCalculated; // Calculated interest based on overdue days

    // Default constructor for JPA
    public OverduePayment() {}

    // Constructor, Getters, and Setters
    public OverduePayment(String transactionId, BigDecimal dueAmount, BigDecimal interestCalculated) {
        this.transactionId = transactionId;
        this.dueAmount = dueAmount;
        this.interestCalculated = interestCalculated;
    }
}