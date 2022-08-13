package com.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EmployeeController {
	
	@Autowired
	EmployeeSer employeeservice;
	
	@GetMapping("/emp")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeservice.getAllEmployees());
		return "index";
	}

}
