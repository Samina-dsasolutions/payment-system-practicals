package com.hibernatepractice.paymentsystem.model;



import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_records")
@Data
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tx_seq") // SEQUENCE: Managed via DB sequence
    @SequenceGenerator(name = "tx_seq", sequenceName = "transaction_sequence", allocationSize = 1)
    private Long id;

    private BigDecimal amount;
}