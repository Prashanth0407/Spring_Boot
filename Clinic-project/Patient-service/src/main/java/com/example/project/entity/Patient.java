package com.example.project.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Patient")
public class Patient {
	@Id
	private int patientId;
	@Column
	private String patientName;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private long mobile;
	@Column
	private String patientProblem;
	

}
