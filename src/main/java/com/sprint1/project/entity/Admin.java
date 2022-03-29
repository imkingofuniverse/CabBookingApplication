package com.sprint1.project.entity;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	private String username;
	private String password;
	private String email;
	private String mobilenumber;
	private String address;

	public Admin() {
		super();
	}
	public Admin(int adminId, String username, String password, String email, String mobilenumber, String address) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.address = address;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
