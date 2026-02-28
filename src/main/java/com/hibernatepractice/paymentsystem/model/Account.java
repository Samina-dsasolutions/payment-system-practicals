package com.hibernatepractice.paymentsystem.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts") // Resolves "Unable to resolve table 'accounts'"
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private String id;

    @Column(name = "balance") // Resolves "Unable to resolve column 'balance'"
    private BigDecimal balance;

    @Column(name = "status") // Resolves "Unable to resolve column 'status'"
    private String status;
}