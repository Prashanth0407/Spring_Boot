package com.prashanth.olx.user;

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
@Table(name="USERS")
public class User {
	@Id
	 private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
  @Column(name="mobile")
  private String phone;
	
}
