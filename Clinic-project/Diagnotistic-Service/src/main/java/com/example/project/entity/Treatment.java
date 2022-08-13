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
@Table(name="Diagnosis")
public class Treatment {
	
	@Id
	private  int id;
	
	@Column
	private String checkupName;
	
	@Column
	private double amount;
	
	

}
