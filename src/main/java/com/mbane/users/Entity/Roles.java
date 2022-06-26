package com.mbane.users.Entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NonNull;


@Entity
@Data
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_roles;
	
	@Column(nullable = false,unique = true,length = 20)
	@NonNull
	private String status;
	
	@OneToMany(mappedBy = "roles")
	@JsonIgnore
	private List<Users> users;
	
		
	
	public Roles(String st)
	{	
		super();
		this.status=st;
	}


	public String getStatus() {
		return status;
	}

	public Roles() {}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Roles [Id_roles=" + Id_roles + ", status=" + status + "]";
	}


	public List<Users> getUsers() {
		return users;
	}


	public void setUsers(List<Users> users) {
		this.users = users;
	}


	public Long getId_roles() {
		return Id_roles;
	}


	public void setId_roles(Long id_roles) {
		Id_roles = id_roles;
	}
	

}
