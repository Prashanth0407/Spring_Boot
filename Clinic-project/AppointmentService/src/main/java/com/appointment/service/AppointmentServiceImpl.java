package com.appointment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.appointment.entity.Appointment;
import com.appointment.entity.AppointmentResponse;
import com.appointment.repository.AppointmentReprository;

@Service
public class AppointmentServiceImpl implements AppoitmentService{

	@Autowired
	AppointmentReprository repo;
	
	@Autowired
	private RestTemplate rt;
	@Override
	public AppointmentResponse addAppoinment(Appointment appoint) {
		Appointment app= repo.save(appoint);
		Map<String,String> treat=new HashMap<>();
		treat.put("id",String.valueOf(app.getTreatmentId()));
		String checkup=rt.getForObject("http://TREATMENT/treatment/name/{id}",String.class,treat);
		Map<String,String> parms=new HashMap<>();
		parms.put("id",String.valueOf(app.getDoctorId()));
		String doctorName=rt.getForObject("http://DOCTOR-SERVICE/doctor/name/{id}",String.class,parms);
		Map<String,String> parmname=new HashMap<>();
		parmname.put("id",String.valueOf(app.getId()));
		String patientName=rt.getForObject("http://PATIENT-SERVICE/patient/name/{id}",String.class,parmname);
		AppointmentResponse response= getAllAppointmentResponse(app,doctorName,checkup,patientName);
         return response;
	}

	@Override
	public List<AppointmentResponse> getAppoinmentList() {
		Appointment app=null;
		List<AppointmentResponse> list=new ArrayList<>();
		     List<Appointment> applist=repo.findAll();
		     for(int i=0;i<applist.size();i++) {
		    	 app=applist.get(i);
		    	 Map<String,String> parms=new HashMap<>();
		 		parms.put("id",String.valueOf(app.getDoctorId()));
		 		String doctorName=rt.getForObject("http://DOCTOR-SERVICE/doctor/name/{id}",String.class,parms);
		 		Map<String,String> treat=new HashMap<>();
		 		treat.put("id",String.valueOf(app.getTreatmentId()));
		 		String checkup=rt.getForObject("http://TREATMENT/treatment/name/{id}",String.class,treat);
		 		Map<String,String> parmname=new HashMap<>();
				parmname.put("id",String.valueOf(app.getId()));
				String patientName=rt.getForObject("http://PATIENT-SERVICE/patient/name/{id}",String.class,parmname);
				list.add(getAllAppointmentResponse(app,doctorName,checkup,patientName));
		     }
		return list;
	}
	
    private  AppointmentResponse getAllAppointmentResponse(Appointment app,String DoctorName,String CheckupName,String patientName) {
    	AppointmentResponse ar=new AppointmentResponse();
    	ar.setId(app.getId());
    	ar.setPatientName(patientName);
    	ar.setDoctorName(DoctorName);
    	ar.setTreatmentName(CheckupName);
    	ar.setDate(app.getDate());
    	ar.setAppointedTime(app.getAppointedTime());
    	return ar;
    }

	@Override
	public AppointmentResponse getByPatientId(Integer id) {
		     Appointment app=repo.findById(id).get();
		     Map<String,String> parms=new HashMap<>();
				parms.put("id",String.valueOf(app.getDoctorId()));
				String doctorName=rt.getForObject("http://DOCTOR-SERVICE/doctor/name/{id}",String.class,parms);
				Map<String,String> treat=new HashMap<>();
				treat.put("id",String.valueOf(app.getTreatmentId()));
				String checkup=rt.getForObject("http://TREATMENT/treatment/name/{id}",String.class,treat);
				
				Map<String,String> parmname=new HashMap<>();
				parmname.put("id",String.valueOf(app.getId()));
				String patientName=rt.getForObject("http://PATIENT-SERVICE/patient/name/{id}",String.class,parmname);
				AppointmentResponse response= getAllAppointmentResponse(app,doctorName,checkup,patientName);
		         return response;
	}
	
}
