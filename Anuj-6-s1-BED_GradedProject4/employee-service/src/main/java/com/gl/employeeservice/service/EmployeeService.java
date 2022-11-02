package com.gl.employeeservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gl.employeeservice.model.Employee;


public interface EmployeeService {

	public Employee getImployeeeById(Long id);
	public List<Employee> getAllEmployees();
	public Employee saveEmployee(Employee e);
	public void deleteEmployee(Employee e);
	public void deleteEmployeeById(Long id);
	public List<Employee> getEmpoloyeesByName(String nm);
	public Employee updateEmployee(long empId, Employee updatedEmp);
	
	
}
