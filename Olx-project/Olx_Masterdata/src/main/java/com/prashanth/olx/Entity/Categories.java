package com.prashanth.olx.Entity;

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
@Table(name="CATEGORIES")
public class Categories {
          
	@Id
	private int id;
	
	@Column(name="name")
	private String category;
	
	@Column(name="description")
	private String description;
	
}
