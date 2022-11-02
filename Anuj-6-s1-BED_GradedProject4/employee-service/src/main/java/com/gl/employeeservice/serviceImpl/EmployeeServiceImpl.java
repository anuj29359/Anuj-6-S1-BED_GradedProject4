package com.gl.employeeservice.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.List;

import org.hibernate.resource.transaction.internal.SynchronizationRegistryStandardImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.stereotype.Service;

import com.gl.employeeservice.model.Employee;
import com.gl.employeeservice.repository.EmployeeRepository;
import com.gl.employeeservice.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private final EmployeeRepository employeeRepository;
	
	


	@Override
	public Employee getImployeeeById(Long id) {
		// TODO Auto-generated method stub
		
		return  this.employeeRepository.findById(id).get();
	}


	@Override
	public void deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		this.employeeRepository.delete(e);
	}

	@Override
	public List<Employee> getEmpoloyeesByName(String nm) {
		// TODO Auto-generated method stub
		Employee empWithName = new Employee();
		empWithName.setName(nm);
		
		ExampleMatcher  exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()).withIgnorePaths("empId", "email");
		
		Example<Employee> employeeNameExample = Example.of(empWithName, exampleMatcher);
		return this.employeeRepository.findAll(employeeNameExample);
	}

	@Override
	public Employee updateEmployee(long empId, Employee updatedEmp) {
		// TODO Auto-generated method stub
		
		Employee emp = this.getImployeeeById(empId);
		System.out.println("Employee to be updated is-" + emp);
		emp.setName(updatedEmp.getName());
		emp.setEmail(updatedEmp.getEmail());
		System.out.println("Updated properties of the employees is-" + emp);
		return this.employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepository.findAll();
	}


	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
//		System.out.println(e);
//		Employee emp = new Employee();
//		System.out.println(emp);
//		emp.setEmail(e.getEmail());
//		emp.setName(e.getName());
		System.out.println("neew employee " + emp);
		return this.employeeRepository.save(emp);
	}

	//delete
	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
		
	}


	public List<Employee> getEmpoloyeesByNameAndEmail(String nm, String email) {
		// TODO Auto-generated method stub
		System.out.println("getEmpoloyeesByNameAndEmail() yet to be implemented");
		return new ArrayList<Employee>();
	}


	public List<Employee> getEmpoloyeesByEmail(String email) {
		// TODO Auto-generated method stub
		
		Employee forEmail = new Employee();
		forEmail.setEmail(email);
		
		ExampleMatcher exampleMatcherforEmail = ExampleMatcher
				.matching()
				.withMatcher(email, ExampleMatcher.
						GenericPropertyMatchers
						.contains()
						.ignoreCase())
				.withIgnorePaths("empId","name");
		
		Example exampleEmail = Example.of(forEmail, exampleMatcherforEmail);
		return this.employeeRepository.findAll(exampleEmail);

	}


	
}
