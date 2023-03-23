package com.toyandbooklibapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyandbooklibapp.exceptions.PaymentNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.Payment;
import com.toyandbooklibapp.model.Toy;
import com.toyandbooklibapp.service.IPaymentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/toyandbooklibapp")
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;

	@PostMapping("/payment/save")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Payment> doPayment(@RequestBody Payment payment) {
		Payment newPayment = paymentService.savePayment(payment);
		return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
	}

	@GetMapping("/payment/{paymentId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Payment> getPayment(@PathVariable("paymentId") int paymentId) throws PaymentNotFoundException {
		Payment payment = paymentService.viewPaymentById(paymentId);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}

	@GetMapping("/payment/all")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public ResponseEntity<List<Payment>> getAllPayments()  throws ResourceNotFoundException{
		List<Payment> payments = paymentService.viewAllPayments();
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}
	
	@PutMapping("/payment/update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) throws PaymentNotFoundException{
		Payment newPayment = paymentService.updatePayment(payment);
		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(newPayment, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/payment/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Payment> deletePayment(@PathVariable("paymentId")Integer paymentId) throws PaymentNotFoundException{
		Payment payment = paymentService.deletePayment(paymentId);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	
	@GetMapping("/payment/{parentId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Payment>> viewPaymentByParent(@PathVariable("parentId") Integer parentId) throws PaymentNotFoundException{
		List<Payment> payments = paymentService.viewPaymentByParent(parentId);
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}

}
