package com.syncbyte.registration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class EmployeeAttendence {
	
	@Id
	private Long employeeCode;
	private Integer attendence;
	
	/*
	 * 
	 * 
	 *
	 */
//	
	

}
