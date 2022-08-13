package com.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EmployeeSerImp implements EmployeeSer {
	
	
	@Autowired
	EmployeeRepository employeerepo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeerepo.findAll();
	}

}
