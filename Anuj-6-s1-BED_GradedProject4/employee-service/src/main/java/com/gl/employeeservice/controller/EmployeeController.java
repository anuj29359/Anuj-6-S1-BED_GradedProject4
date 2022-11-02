package com.gl.employeeservice.controller;

import java.util.List;
import java.util.Set;

import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeeservice.model.Employee;
import com.gl.employeeservice.serviceImpl.EmployeeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeServiceImpl employeeServiceImpl;

	// save
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeServiceImpl.saveEmployee(employee);
	}

	// get
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return this.employeeServiceImpl.getAllEmployees();
	}

	// @GetMapping("/{id}")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") long empId) {
		return this.employeeServiceImpl.getImployeeeById(empId);
	}

	// @GetMapping("/{name}")
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getEmployeesByName(@RequestParam(name = "name") String nm,
			@RequestParam(value = "email") String email) {
		
		System.out.println("Request parameters are: [name]: " + nm + "\t [email]:" + email);
		if(email.isBlank() | email.isEmpty() | email==null) {
			return this.employeeServiceImpl.getEmpoloyeesByName(nm);
		}
		else if(nm.isBlank() | nm.isEmpty() | nm==null) {
			return this.employeeServiceImpl.getEmpoloyeesByEmail(email);
		}
		
		return this.employeeServiceImpl.getEmpoloyeesByNameAndEmail(nm,email);
	}

	// remove
	@DeleteMapping("/{id}")
	public void removeEmployee(@PathVariable("id") long empId) {
		this.employeeServiceImpl.deleteEmployeeById(empId);
	}

	@PutMapping(path = "/{id}")
	public Employee updateEmployee(@PathVariable("id") Long empId, @RequestBody Employee e) {
		return employeeServiceImpl.updateEmployee(empId, e);
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET) public List<Employee>
	 * getEmployeeByEmail(@RequestParam(value = "email") String email){ return null;
	 * }
	 */

}
