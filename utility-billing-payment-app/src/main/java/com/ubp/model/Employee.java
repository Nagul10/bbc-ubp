package com.ubp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private long employeeId;
	private String employeeName;
	private String company;
	private String email;
	private long mobile;
}
