package com.mbane.users.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;



@Entity
@Data
public class Users {




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_user;
	

	private String name;
	@Column(nullable = false,unique = true)
	private String prenom;
    @Column(nullable = false,unique = true)
	private String email;

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(("dd/MM/yyyy"));
	
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date datedeNaissance;


	private String company;

	private String password;
	
	private String Address;
	
	private String Phone;
	
	private boolean enabled;
	
	@ManyToOne
	private Roles roles;
		 

	
	public Date getDatedeNaissance() {
		return datedeNaissance;
	}

	public void setDatedeNaissance(String datedeNaissa) {
		
		this.datedeNaissance = ParseDat(datedeNaissa);
	}

	private Date ParseDat(String datedeNaissa) {
		 try {
		      return simpleDateFormat.parse(datedeNaissa);
		    } catch (final ParseException e) {
		      return new Date();
		    }
	}


	
	public Users(String na,String pr,String email,String com,String p,Roles ro)
	{
		super();
		this.name=na;
		this.prenom=pr;
		this.email=email;
		this.company=com;
		this.password=p;
		this.roles=ro;
	}
	
	public Users() {
   
	}
	
	@Override
	public String toString() {
		return "Users [Id_user=" + Id_user + ", name=" + name + ", prenom=" + prenom + ", email=" + email
				+ ", datedeNaissance=" + datedeNaissance + ", company=" + company + ", password=" + password
				+ ", Address=" + Address + ", Phone=" + Phone + ", enabled=" + enabled + ", roles=" + roles + "]";
	}

	public Long getId() {
		return Id_user;
	}

	public void setId(Long id) {
		Id_user = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Long getId_user() {
		return Id_user;
	}

	public void setId_user(Long id_user) {
		Id_user = id_user;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setDatedeNaissance(Date datedeNaissance) {
		this.datedeNaissance = datedeNaissance;
	}
	
	
}
