package com.hibernatepractice.paymentsystem.model;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data // Use Lombok to handle Boilerplate, as suggested for Spring-based APIs
public class AutoDebitRequest {

    @NotNull(message = "Account ID is mandatory")
    private String accountId;

    @Min(value = 0, message = "Interest cannot be negative")
    private double calculatedInterest;
}