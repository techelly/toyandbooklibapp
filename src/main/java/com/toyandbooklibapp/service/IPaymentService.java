package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.model.Payment;

public interface IPaymentService {

	public Payment savePayment(Payment payment);

	public Payment viewPaymentById(Integer paymentId);

	public List<Payment> viewAllPayments();

	public Payment updatePayment(Payment payment);

	public Payment deletePayment(Integer paymentId);

	public List<Payment> viewPaymentByParent(Integer parentId);

}
