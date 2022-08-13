package com.appointment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Appointment")
public class Appointment {
   
	@Id
	private int id;
	
	@Column
	private int doctorId;
	
	@Column
	private Date date;
	
	@Column
	private String appointedTime;
	
	@Column
	private int treatmentId;
	
}
