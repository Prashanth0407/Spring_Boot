package com.appointment.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
		   
		private int id;
		
		private String patientName;
		
		private String DoctorName;
		
		private Date date;
		
		private String appointedTime;
		
		private String treatmentName;
		
	
}
