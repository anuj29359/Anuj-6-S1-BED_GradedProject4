package com.gl.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gl.employeeservice.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
