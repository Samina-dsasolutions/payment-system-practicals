package com.hibernatepractice.paymentsystem.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts") // Matches the 'UPDATE accounts' query
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private String id;

    @Column(name = "balance") // Matches 'SET balance'
    private BigDecimal balance;

    @Column(name = "status")  // Matches 'WHERE status'
    private String status;
}