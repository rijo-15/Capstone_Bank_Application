package com.learning.entity;
import javax.persistence.*;

@Entity
@Table
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adminId",unique=true, nullable=false)
	private long adminId;
	@Column(name="adminUsername",unique=true, nullable=false)
	private String username;
	@Column(name="adminPassword", nullable=false)
	private String password;
	@Column(name="adminfn", nullable=false)
	private String firstname;
	@Column(name="adminln", nullable=false)
	private String Lastname;
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public Admin() {
		super();
	}
	
	
}
