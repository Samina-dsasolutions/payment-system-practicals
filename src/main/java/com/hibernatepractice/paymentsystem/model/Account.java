package com.hibernatepractice.paymentsystem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account {
    @Id
    private Long id;
    private BigDecimal balance;
    private String ownerName;
}