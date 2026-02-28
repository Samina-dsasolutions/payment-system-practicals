package com.hibernatepractice.paymentsystem.model;



import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OverdueAccount {

    @Id // If this is the DB key, remove @GeneratedValue if it's not auto-incrementing in MySQL
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "principal_amount")
    private BigDecimal principalAmount;

    @Column(name = "accrued_interest")
    private BigDecimal accruedInterest;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverdueAccount that = (OverdueAccount) o;
        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}