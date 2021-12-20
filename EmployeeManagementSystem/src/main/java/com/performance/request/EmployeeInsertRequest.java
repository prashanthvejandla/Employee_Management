package com.performance.request;

import java.util.UUID;

public class EmployeeInsertRequest {
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private String address;
	private String joinDate;
	private String role;
	private String teamName;
	private double salaryInLakhs;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getSalaryInLakhs() {
		return salaryInLakhs;
	}
	public void setSalaryInLakhs(double salaryInLakhs) {
		this.salaryInLakhs = salaryInLakhs;
	}
}
