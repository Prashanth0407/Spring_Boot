package com.prashanth.olx.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ADV_STATUS")
public class AdvStatus {

	
	@Id
	private int id;
	
	@Column(name="status")
	private String status;
}
