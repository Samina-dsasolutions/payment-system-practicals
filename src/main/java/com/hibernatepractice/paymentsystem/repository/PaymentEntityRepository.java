package com.hibernatepractice.paymentsystem.repository;



import com.hibernatepractice.paymentsystem.model.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentEntityRepository extends CrudRepository<PaymentEntity, Long> {
}