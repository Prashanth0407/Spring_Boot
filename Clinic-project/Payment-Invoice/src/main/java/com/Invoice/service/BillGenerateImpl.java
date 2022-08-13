package com.Invoice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Invoice.Entity.Appointment;
import com.Invoice.Entity.BillGenarate;
import com.Invoice.Entity.Patient;
import com.Invoice.Entity.Payment;
import com.Invoice.repository.PaymentRepository;

@Service
public class BillGenerateImpl implements BillGenerateService{
      
	@Autowired
	private PaymentRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private BillGenarate getBillDetails(Payment payment) {
		BillGenarate bill=new BillGenarate();
		bill.setInvoice(payment.getInvoice());
		bill.setAmmount(payment.ammount);
		Map<String, String> params = new HashMap<>();
	       params.put("id", String.valueOf(payment.getPatientId()));
		ResponseEntity<Patient> response=restTemplate.getForEntity("http://patient-service/patient/{id}",Patient.class,params);
		bill.setPatient(response.getBody());
		ResponseEntity<Appointment> resp=restTemplate.getForEntity("http://APPOINTMENT-SERVICE/Appointment/{id}",Appointment.class,params);
		bill.setAppointment(resp.getBody());
		
		return bill;
	}

	@Override
	public BillGenarate getBillTrascript(int id) {
		      Payment pay=repo.findByPatientId(id);
		return getBillDetails(pay);
	}
    
	 
}
