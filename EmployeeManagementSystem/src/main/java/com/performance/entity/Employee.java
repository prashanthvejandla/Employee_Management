package com.performance.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE" , schema="spm")
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private String address;
	private String joinDate;
	private String role;
	private String teamName;
	private double salaryInLakhs;
	
	//constructor
	public Employee() {
		
	}
	/*public Employee(long id, String firstName, String lastName, String dob, String address, String joinDate,
			String role, String teamName, double salaryInLakhs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.joinDate = joinDate;
		this.role = role;
		this.teamName = teamName;
		this.salaryInLakhs = salaryInLakhs;
	}*/
	
	//getter and setters
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Column
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	@Column
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	@Column
	public double getSalaryInLakhs() {
		return salaryInLakhs;
	}
	public void setSalaryInLakhs(double salaryInLakhs) {
		this.salaryInLakhs = salaryInLakhs;
	}
}
