package com.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	
	 public Doctor findByDoctorName(String name);
	 
	 public List<Doctor> findBySpecilization(String specilization);
	 
	 
}
