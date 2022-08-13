package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.project.entity.Patient;
import com.example.project.service.Patient_Service;

@RestController
@RequestMapping("/patient")
public class PatientController {

	
	@Autowired
	Patient_Service patientService;
	
	@PostMapping()
	public ResponseEntity<Patient> addNewPatient(@RequestBody Patient patient) 
	{
		
			return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
		
		
	}
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatient() throws Exception
	{
		return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
		
		
	}
	@GetMapping("/{patientId}")
	public ResponseEntity<Patient> getBypatientsId(@PathVariable int patientId) throws Exception
	{
		
			return new ResponseEntity<>(patientService.getByPatientId(patientId), HttpStatus.OK);
		
	}
	@GetMapping("/patientname/{patient_name}")
	public ResponseEntity<Patient> getBypatientsName(@PathVariable String patient_name) throws Exception
	{
			return new ResponseEntity<>(patientService.getByPatientName(patient_name), HttpStatus.OK);
		
		
	}
	
	@PutMapping("/{patient_id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int patient_id,Patient patient) throws Exception
	{
		
			return new ResponseEntity<Patient>(patientService.updatePatient(patient_id,patient), HttpStatus.ACCEPTED);
		
		
	}
   @DeleteMapping("/delete/{patient_id}")
   
	public ResponseEntity<Boolean> deletePatients(@PathVariable int patient_id) throws Exception
	{
		
			return new ResponseEntity<>(patientService.deletePatient(patient_id), HttpStatus.OK);
		} 
   @GetMapping("/name/{patientId}")
   public ResponseEntity<String> updatePatient(@PathVariable int patientId) throws Exception
	{
		
			return new ResponseEntity<>(patientService.getPatientName(patientId), HttpStatus.ACCEPTED);
		
		
	}
}
     
   
   
