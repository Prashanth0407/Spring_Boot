package com.Invoice.Entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	
	private String DoctorName;

	private Date date;
	
	private String appointedTime;
	
	
	private String treatmentName;

}
