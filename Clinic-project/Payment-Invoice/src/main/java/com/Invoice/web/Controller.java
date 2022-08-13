package com.Invoice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Invoice.Entity.BillGenarate;
import com.Invoice.Entity.Payment;
import com.Invoice.service.BillGenerateService;
import com.Invoice.service.PaymentService;

@RestController
@RequestMapping("/Payment")
public class Controller {

	@Autowired
	PaymentService paymentservice;
	
	@Autowired
	BillGenerateService billservice;
	
	@PostMapping
	ResponseEntity<String> payBill(@RequestBody Payment payment){
		return new ResponseEntity<>(paymentservice.payBill(payment),HttpStatus.CREATED);
	}
	@GetMapping("/bill/{id}")
	ResponseEntity<BillGenarate> getbilltranscript(@PathVariable int id){
		return new ResponseEntity<>(billservice.getBillTrascript(id),HttpStatus.OK);
	}
}  
