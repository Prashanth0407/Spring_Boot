package com.Invoice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	
	private int patientId;

	private String patientName;
    
	private int age;
	
	private String gender;
	
	private long mobile;
}
