package com.doctor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.Exception.DoctorNotFoundException;
import com.doctor.entity.Doctor;
import com.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	 @Autowired
	 DoctorRepository repo;
	@Override
	public Doctor addDoctorDetails(Doctor doctor) {
		
		return repo.save(doctor);
	}
	

	@Override
	public List<Doctor> getAllDoctorList() {
		return repo.findAll();
	}

	@Override
	public boolean delete(int id) {
		 repo.deleteById(id);
		return true;
	}


	@Override
	public Doctor getByName(String name) throws DoctorNotFoundException {
		  Doctor details= repo.findByDoctorName(name);
		  if(details != null) {
		return details;
	}else {
		throw new DoctorNotFoundException("the Dr."+name+" is not available in our clinic" );
	}
	}


	@Override
	public List<Doctor> getBySpecilization(String specilization) throws DoctorNotFoundException {
		List<Doctor> specifics=repo.findBySpecilization(specilization);
		if(specifics.isEmpty()) {
			throw new DoctorNotFoundException("this "+specilization +" service is not available" );
		}
		return specifics;
	}


	@Override
	public Doctor update(int doctorId, Doctor doctor) throws DoctorNotFoundException {
		Optional<Doctor> doc=repo.findById(doctorId);
		if(doc.isEmpty()) {
			throw new DoctorNotFoundException(doctorId+" is not found");
		
		}
		return repo.save(doctor);
		
	}


	@Override
	public String getDoctorName(int id) {
		Doctor doc=repo.findById(id).get();
		String name=doc.getDoctorName();
		return name;
	}


	@Override
	public Doctor getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}
