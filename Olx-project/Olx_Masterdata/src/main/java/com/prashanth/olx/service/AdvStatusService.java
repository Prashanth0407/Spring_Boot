package com.prashanth.olx.service;

import java.util.List;

import com.prashanth.olx.Entity.AdvStatus;

public interface AdvStatusService {
    
	 public List<AdvStatus> getAllStatus();

	 public String getByStatusId(Integer id);
}
