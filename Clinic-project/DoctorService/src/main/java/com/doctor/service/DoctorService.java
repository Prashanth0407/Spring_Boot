package com.doctor.service;

import java.util.List;

import com.doctor.Exception.DoctorNotFoundException;
import com.doctor.entity.Doctor;

public interface DoctorService {

	  public Doctor addDoctorDetails(Doctor doctor);
	  
	  public List<Doctor> getAllDoctorList();
	  
	  public Doctor getByName(String name) throws DoctorNotFoundException;
	  
	  public List<Doctor> getBySpecilization(String specilization) throws DoctorNotFoundException;
	  
	  public boolean delete(int id);
	  
	  public Doctor update(int doctorId,Doctor doctor) throws DoctorNotFoundException;
	  
	  public String getDoctorName(int id);
	  
	  public Doctor getById(int id);
}
