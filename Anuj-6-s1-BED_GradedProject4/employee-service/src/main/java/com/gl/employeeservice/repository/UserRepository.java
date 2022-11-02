package com.gl.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeeservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
