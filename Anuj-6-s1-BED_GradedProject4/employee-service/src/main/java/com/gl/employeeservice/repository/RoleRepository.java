package com.gl.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeeservice.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
