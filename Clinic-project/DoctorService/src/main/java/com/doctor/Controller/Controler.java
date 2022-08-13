package com.doctor.Controller;

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

import com.doctor.Exception.DoctorNotFoundException;
import com.doctor.entity.Doctor;
import com.doctor.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class Controler {

	@Autowired
	DoctorService doctorservice;
	
	@PostMapping
	ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<>(doctorservice.addDoctorDetails(doctor),HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	ResponseEntity<List<Doctor>> getAllDoctor(){
		return new ResponseEntity<>(doctorservice.getAllDoctorList(),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<Boolean> delete(@PathVariable int id){
		return new ResponseEntity<>(doctorservice.delete(id),HttpStatus.OK);
	}
	
	@GetMapping("doctorName/{name}")
	ResponseEntity<Doctor> getByDoctorname(@PathVariable String name) throws DoctorNotFoundException{
		return new ResponseEntity<>(doctorservice.getByName(name),HttpStatus.OK);
	}
	@GetMapping("specilization/{specilization}")
	ResponseEntity<List<Doctor>> getBySpecilization(@PathVariable String specilization) throws DoctorNotFoundException{
		return new ResponseEntity<>(doctorservice.getBySpecilization(specilization),HttpStatus.OK);
	}
	@PutMapping("{id}")
	ResponseEntity<Doctor> update(@PathVariable int id,@RequestBody Doctor doctor) throws DoctorNotFoundException{
		return new ResponseEntity<>(doctorservice.update(id, doctor),HttpStatus.OK);
	}
	
	@GetMapping("name/{doctorid}")
	ResponseEntity<String> getByDoctorname(@PathVariable int doctorid) throws DoctorNotFoundException{
		return new ResponseEntity<>(doctorservice.getDoctorName(doctorid),HttpStatus.OK);
	}
	@GetMapping("{id}")
	ResponseEntity<Doctor> update(@PathVariable int id) throws DoctorNotFoundException{
		return new ResponseEntity<>(doctorservice.getById(id),HttpStatus.OK);
	}
}
