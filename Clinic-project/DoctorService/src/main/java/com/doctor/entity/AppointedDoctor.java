package com.doctor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AppointedDoctor")
public class AppointedDoctor {
    
 	 @Id
 	 public int doctorId;
 	 
 	 @Column
 	 public String doctorName;
 	 
 	 @Column
 	 public Date appointedDate;
 	 
 	 @Column
	 public String appointedTime;
 	 
 	 @Column
 	 public long mobileNo;
}
