package com.appointment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.entity.Appointment;
import com.appointment.entity.AppointmentResponse;
import com.appointment.service.AppoitmentService;

@RestController
@RequestMapping("/Appointment")
public class Controller {
   
	@Autowired
	AppoitmentService appoint;
	
	@PostMapping
	ResponseEntity<AppointmentResponse> addTheAppointed(@RequestBody Appointment apoint){
		return new ResponseEntity<>(appoint.addAppoinment(apoint),HttpStatus.ACCEPTED);
	}
	 
	@GetMapping
	ResponseEntity<List<AppointmentResponse>> gettAllAppointment(){
		return new ResponseEntity<>(appoint.getAppoinmentList(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/{id}")
	ResponseEntity<AppointmentResponse> getByPatientId(@PathVariable Integer id){
		return new ResponseEntity<>(appoint.getByPatientId(id),HttpStatus.ACCEPTED);
	}
}
