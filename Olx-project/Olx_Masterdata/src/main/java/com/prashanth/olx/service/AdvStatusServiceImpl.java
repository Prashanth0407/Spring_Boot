package com.prashanth.olx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanth.olx.Entity.AdvStatus;
import com.prashanth.olx.reprository.AdvStatusReprository;

@Service
public class AdvStatusServiceImpl implements  AdvStatusService{
   
     @Autowired	
	 AdvStatusReprository ar;
	@Override
	public List<AdvStatus> getAllStatus() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}
	
	@Override
	public String getByStatusId(Integer statusId) {
	Optional<AdvStatus> adv=	ar.findById(statusId);
	String status=adv.get().getStatus();
	return status;
	}

}
