package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.Treatment;
import com.example.project.exception.TreatmentNotFoundException;
import com.example.project.repository.DiagnotisticRepo;

@Service
public class DiagnotisticServiceImpl implements DiagnotisticService {
	
	@Autowired
	DiagnotisticRepo diagnotisticRepo;

	@Override
	public Treatment addPatient(Treatment treatment){
		
		return diagnotisticRepo.save(treatment);
		
	}

	@Override
	public List<Treatment> getAllProducts(){
		return diagnotisticRepo.findAll();
	}

	@Override
	public Treatment getById(int id) throws TreatmentNotFoundException {
		Treatment currentTreatment=diagnotisticRepo.findById(id).get();
		if(currentTreatment==null)
		{
			throw new TreatmentNotFoundException("Treatment Not Exist");
		}
		return currentTreatment;
	}

	@Override
	public Treatment getcheckupName(String checkup_name) throws TreatmentNotFoundException {
		Treatment currentTreatment=diagnotisticRepo.findByCheckupName(checkup_name);
		if(currentTreatment==null)
		{
			throw new TreatmentNotFoundException("Treatment Not Exist");
		}
		return currentTreatment;
	}

	@Override
	public Treatment updateTreatment(int id, Treatment treatment) throws TreatmentNotFoundException {
		Treatment currentTreatment=diagnotisticRepo.findById(id).get();
		if(currentTreatment==null)
		{
			throw new TreatmentNotFoundException("Treatment Not Found");
		}
		
			return diagnotisticRepo.save(currentTreatment);

	}

	@Override
	public boolean deleteTreatment(int id) throws TreatmentNotFoundException {
		Treatment currentTreatment=diagnotisticRepo.findById(id).get();
		
		if(currentTreatment==null)
		{
			throw new TreatmentNotFoundException("treatment Not Found");
		}
		else
		{
			diagnotisticRepo.delete(currentTreatment);
		}

		return true;
	}

	@Override
	public String getTreatmentName(int id) {
		Treatment treat=diagnotisticRepo.findById(id).get();
		return treat.getCheckupName();
	}
	
	
}
