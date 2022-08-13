package com.appointment.service;

import java.util.List;

import com.appointment.entity.Appointment;
import com.appointment.entity.AppointmentResponse;

public interface AppoitmentService {
     
	public AppointmentResponse addAppoinment(Appointment appoint);
	
	public List<AppointmentResponse> getAppoinmentList();
	
	public AppointmentResponse getByPatientId(Integer id);
	
}
