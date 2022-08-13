package com.doctor.entity;

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
@Table(name="Doctor")
public class Doctor {
    
	@Id
	private int doctorId;
	
	@Column(name="name")
	private String doctorName;
	
	@Column(name="mobileno")
	private long mobileNo;
	
	@Column(name="specilization")
	private String specilization;
	
	@Column(name="workingmorninghours")
	private String workingmorninghours;
	
	@Column(name="workingeveninghours")
	private String workingeveninghours;
}
