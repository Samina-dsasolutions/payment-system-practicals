package com.hibernatepractice.paymentsystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Account {
    private String id;
    private BigDecimal balance;
}