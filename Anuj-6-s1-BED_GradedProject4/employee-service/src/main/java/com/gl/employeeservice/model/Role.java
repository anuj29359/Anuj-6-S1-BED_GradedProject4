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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
@Data
@Builder
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private long id;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column
	private boolean isActive;
	
	@ManyToMany(mappedBy = "myRole", fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	private List<User> myUser;

	public void addUser(User user) {
		// TODO Auto-generated method stub
		if(this.myUser == null) {
			this.myUser = new ArrayList<>();
			this.myUser.add(user);
		}
		else {
			this.myUser.add(user);
		}
	}

}
