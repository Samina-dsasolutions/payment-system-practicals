package com.hibernatepractice.paymentsystem.model;



import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch_reports")
@Data
public class BatchReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY: Database manages auto-increment
    private Long id;

    private String reportType;
    private LocalDateTime generatedAt;
}