package com.hibernatepractice.paymentsystem.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
public class PaymentEntity {
    // LEAKAGE: This ID field exists only to satisfy the relational database requirement
    // for a primary key, even though the business logic might not need it.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private String currency;
}