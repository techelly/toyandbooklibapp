package com.toyandbooklibapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyandbooklibapp.entities.PaymentEntity;
import com.toyandbooklibapp.exceptions.PaymentNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.Payment;
import com.toyandbooklibapp.repositories.IPaymentRepository;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;

	@Override
	public Payment savePayment(Payment payment) {
		// convert payment model to payment entity

		PaymentEntity paymentEntity = new PaymentEntity();
		BeanUtils.copyProperties(payment, paymentEntity);

		PaymentEntity newPaymentEntity = paymentRepository.save(paymentEntity);
		// covert payment entity to payment model

		Payment newPayment = new Payment();
		BeanUtils.copyProperties(newPaymentEntity, newPayment);

		return newPayment;
	}

	@Override
	public Payment viewPaymentById(Integer paymentId) throws PaymentNotFoundException {
		Optional<PaymentEntity> optionalPayment = paymentRepository.findById(paymentId);
		if (!optionalPayment.isPresent()) {
			throw new PaymentNotFoundException("Payment not existing with id:" + paymentId);
		}
		PaymentEntity paymentEntity = optionalPayment.get();
		// convert payment entity to payment model
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentEntity, payment);
		return payment;
	}

	@Override
	public List<Payment> viewAllPayments() throws ResourceNotFoundException{
		List<PaymentEntity> paymentEntities = (List<PaymentEntity>) paymentRepository.findAll();
		if (paymentEntities.size() > 0) {
			// convert payment entity list to payment list
			List<Payment> payments = new ArrayList<>();
			paymentEntities.forEach(pentity -> {
				Payment payment = new Payment();
				BeanUtils.copyProperties(pentity, payment);
				payments.add(payment);
			});
			return payments;
		} else {
			throw new ResourceNotFoundException("No payments found");
		}
	}

	@Override
	public Payment updatePayment(Payment payment) throws PaymentNotFoundException {
		Optional<PaymentEntity> optionalPayment = paymentRepository.findById(payment.getPaymentId());
		if (!optionalPayment.isPresent()) {
			throw new PaymentNotFoundException("Payment not existing with id:" + payment.getPaymentId());
		}
		PaymentEntity paymentEntity = optionalPayment.get();
		// convert payment entity to payment model
		Payment newPayment = new Payment();
		BeanUtils.copyProperties(paymentEntity, newPayment);

		PaymentEntity newPaymentEntity = paymentRepository.save(paymentEntity);
		// convert payment entity to payment model
		Payment nPayment = new Payment();
		BeanUtils.copyProperties(newPaymentEntity, nPayment);
		return nPayment;
	}

	@Override
	public Payment deletePayment(Integer paymentId) throws PaymentNotFoundException {
		Optional<PaymentEntity> optionalPayment = paymentRepository.findById(paymentId);
		if (!optionalPayment.isPresent()) {
			throw new PaymentNotFoundException("Payment not existing with id:" + paymentId);
		}
		PaymentEntity paymentEntity = optionalPayment.get();
		paymentRepository.delete(paymentEntity);
		// convert payment entity to payment model
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentEntity, payment);
		return payment;
	}

	// TODO
	@Override
	public List<Payment> viewPaymentByParent(Integer parentId) {
		List<Payment> payments = viewAllPayments();
		/*
		 * //List<PaymentEntity> paymentEntities = viewAllPayments(); if
		 * (payments.size() > 0) { payments.forEach(pentity-> ); // convert payment
		 * entity list to payment list List<Payment> payments = new ArrayList<>();
		 * paymentEntities.forEach(pentity -> { Payment payment = new Payment();
		 * BeanUtils.copyProperties(pentity, payment); payments.add(payment); }); return
		 * payments; } else { throw new
		 * PaymentNotFoundException("No payments found for this parent id "+parentId); }
		 */
		return payments;
	}

}
