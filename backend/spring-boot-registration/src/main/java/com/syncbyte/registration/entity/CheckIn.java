package com.syncbyte.registration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class CheckIn {

	@Id
	private Long employeeCode;
	private String password;
	private boolean fingerprint;
}
