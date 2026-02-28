package com.hibernatepractice.paymentsystem.repository;



import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentTransaction, Long> {
    // Spring Data JPA provides the implementation automatically
    List<PaymentTransaction> findByStatus(String status);
}