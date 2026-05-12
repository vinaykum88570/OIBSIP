package com.onlineReservationSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ors_userRegister")
public class UserRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	private String password;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public UserRegister(Integer userId, String name, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
	}
	
	public UserRegister() {
		
	}
	
	@Override
	public String toString() {
		return "UserRegister [userId=" + userId + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
