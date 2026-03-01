package com.hibernatepractice.paymentsystem.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean // Prevents Spring from instantiating this intermediate repository
public interface BasePaymentRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    // Shared business logic: Every payment entity needs to filter for 'ACTIVE' status
    List<T> findAllActive();
}