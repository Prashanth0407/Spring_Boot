package com.Invoice.Entity;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillGenarate {

	
	private long invoice;
		
	private double ammount;
		
	private Patient patient;
	
	private Appointment appointment;
}
