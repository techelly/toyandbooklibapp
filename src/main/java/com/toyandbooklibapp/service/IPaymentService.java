package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.exceptions.PaymentNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.Payment;

public interface IPaymentService {

	public Payment savePayment(Payment payment);

	public Payment viewPaymentById(Integer paymentId) throws PaymentNotFoundException;

	public List<Payment> viewAllPayments() throws ResourceNotFoundException;

	public Payment updatePayment(Payment payment) throws PaymentNotFoundException;

	public Payment deletePayment(Integer paymentId) throws PaymentNotFoundException;

	public List<Payment> viewPaymentByParent(Integer parentId) throws PaymentNotFoundException;

}
