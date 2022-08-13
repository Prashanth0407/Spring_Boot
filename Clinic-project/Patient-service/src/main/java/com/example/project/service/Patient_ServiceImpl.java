package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.Patient;
import com.example.project.repository.PatientRepo;

@Service
public class Patient_ServiceImpl implements Patient_Service{

	@Autowired
	PatientRepo patientRepo;
	
	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		 List<Patient> check=patientRepo.findAll();
		
		return  check;
	}

	@Override
	public Patient updatePatient(int patientId, Patient patient) throws Exception {
		Patient currentPatient=patientRepo.findByPatientId(patientId);
		
		if(currentPatient==null)
		{
			throw new Exception("Patient Not Found");
		}
		
		return patientRepo.save(currentPatient);
	}

	@Override
	public boolean deletePatient(int patient_id) throws Exception {
		
		Optional<Patient> currentPatient=patientRepo.findById(patient_id);
		if(currentPatient.isPresent())
		{
			patientRepo.deleteById(patient_id);
			return true;
		
		}
		else
		{
			throw new Exception ("Patient  Not Found");
		}
	}

	@Override
	public Patient getByPatientId(int patient_id) throws Exception {
		
		Patient currentPatient=patientRepo.findById(patient_id).get();
		
		if(currentPatient==null)
		{
			throw new Exception("Patient Not Exist");
		}
		return currentPatient;
	}



	@Override
	public Patient getByPatientName(String patient_name) throws Exception {
		Patient currentPatient=patientRepo.findByPatientName(patient_name);
		if (currentPatient==null)
		{
			throw new Exception("Patient Not Found");
		}
		return currentPatient;
	}

	@Override
	public String getPatientName(int id) {
		Patient pat=patientRepo.findById(id).get();
		String name=pat.getPatientName();
		return name;
	}
	
}
