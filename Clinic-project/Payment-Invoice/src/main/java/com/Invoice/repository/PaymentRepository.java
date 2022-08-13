package com.Invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Invoice.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	public Payment findByPatientId(int id);
	
	
}
