package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.Patient;


@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

	List<Patient> findAll(Specification<Patient> specification);

	Patient findByPatientName(String patientname);
	
	Patient findByPatientId(int patientId);
  
}
