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

import com.example.project.entity.Treatment;
import com.example.project.exception.TreatmentNotFoundException;
import com.example.project.service.DiagnotisticService;

@RestController
@RequestMapping("/treatment")
public class DiagnotisticController {

	@Autowired
	DiagnotisticService diagnotisticService;
	
	@PostMapping()
	public ResponseEntity<Treatment> addNewTreatments(@RequestBody Treatment treatment)	{
		
			return new ResponseEntity<>(diagnotisticService.addPatient(treatment), HttpStatus.CREATED);
	}
	@GetMapping()
	public ResponseEntity<List<Treatment>> getAllTreatment()
	{
		
			return new ResponseEntity<>(diagnotisticService.getAllProducts(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Treatment> getByIds(@PathVariable int id ) throws TreatmentNotFoundException
	{
		
			return new ResponseEntity<Treatment>(diagnotisticService.getById(id), HttpStatus.OK);
	}
	@GetMapping("/{checkup_name}")
	public ResponseEntity<Treatment> getByName(@PathVariable String checkup_name ) throws TreatmentNotFoundException
	{
		
			return new ResponseEntity<>(diagnotisticService.getcheckupName(checkup_name), HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Treatment> updateTreatments(@PathVariable int id,@RequestBody Treatment treatment ) throws TreatmentNotFoundException
	{
		
			return new ResponseEntity<>(diagnotisticService.updateTreatment(id,treatment), HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteTreatments(@PathVariable int id) throws TreatmentNotFoundException
	{
		
			return new ResponseEntity<>(diagnotisticService.deleteTreatment(id), HttpStatus.OK);
	}
	@GetMapping("/name/{id}")
	public ResponseEntity<String> getByTreatmentName(@PathVariable int id ) 
	{
		
			return new ResponseEntity<>(diagnotisticService.getTreatmentName(id), HttpStatus.OK);
	}
	
}
