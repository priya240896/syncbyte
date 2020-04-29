package com.syncbyte.registration.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table
@Data
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;
	private Long employeecode;
	private String name;
	private Date dob;
	private String password;
	private boolean fingerprint;
	private Integer attendenceCount;
	
	

}
