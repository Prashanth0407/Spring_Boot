package com.example.project.service;

import java.util.List;

import com.example.project.entity.Patient;

public interface Patient_Service {

	public Patient addPatient(Patient patient) ;

	public List<Patient> getAllPatients();

	public Patient updatePatient(int patient_id, Patient patient) throws Exception;

	public boolean deletePatient(int patient_id) throws Exception;

	public Patient getByPatientId(int patient_id) throws Exception;

	public Patient getByPatientName(String patient_name) throws Exception;

	public String getPatientName(int id);
}
