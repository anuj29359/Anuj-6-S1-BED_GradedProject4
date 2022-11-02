package com.gl.employeeservice.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "user_name")
	private String name;

	@Column(name = "user_password")
	private String password;

	@Column(name = "user_email")
	private String email;

	@Column(name = "is_ative")
	private boolean isActive;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE, 
			fetch = FetchType.EAGER)
	@JoinTable(name = "user_role"
	, joinColumns = 
		@JoinColumn(name = "user_id")
	, inverseJoinColumns = 
		@JoinColumn(name = "role_id")
	)
	private List<Role> myRole;
	
	
	
	public void addRole(Role pr) {
		System.out.println("Adding role " + pr + "to the user " + this.toString());
		if(this.myRole == null) {
			this.myRole = new ArrayList<>();
		}
		
		this.myRole.add(pr);
		//pr.addUser(this);
	}

}
