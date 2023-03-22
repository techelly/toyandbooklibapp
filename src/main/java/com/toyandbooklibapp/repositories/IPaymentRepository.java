package com.toyandbooklibapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toyandbooklibapp.entities.PaymentEntity;

@Repository
public interface IPaymentRepository extends CrudRepository<PaymentEntity, Integer>{

}
