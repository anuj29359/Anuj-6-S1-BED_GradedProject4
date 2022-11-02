package com.gl.employeeservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(name = "employee")
public class Employee {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;
	@Column
	private String name;
	@Column
	private String email;
	//private Date dob;
	
}
