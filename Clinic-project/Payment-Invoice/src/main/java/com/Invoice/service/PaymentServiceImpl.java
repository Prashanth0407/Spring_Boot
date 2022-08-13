package com.Invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Invoice.Entity.Payment;
import com.Invoice.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repo;

	@Override
	public String payBill(Payment payment) {
         repo.save(payment);
         String masg="Succesfully trasaction completed ";
		return masg;
	}

}
