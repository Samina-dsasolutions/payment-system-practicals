package com.hibernatepractice.paymentsystem.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OverdueAccount {
    @Id
    private Long accountId;
    private BigDecimal principalAmount;
    private BigDecimal accruedInterest;
}
