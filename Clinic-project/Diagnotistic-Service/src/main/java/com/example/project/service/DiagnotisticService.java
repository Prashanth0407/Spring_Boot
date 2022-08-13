package com.example.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project.entity.Treatment;
import com.example.project.exception.TreatmentNotFoundException;

@Service
public interface DiagnotisticService {

	Treatment addPatient(Treatment treatment);

	List<Treatment> getAllProducts();

	Treatment getById(int id) throws TreatmentNotFoundException;

	Treatment getcheckupName(String checkup_name) throws TreatmentNotFoundException;

	Treatment updateTreatment(int id, Treatment treatment) throws TreatmentNotFoundException;

	boolean deleteTreatment(int id) throws TreatmentNotFoundException;

	public String getTreatmentName(int id);


}
