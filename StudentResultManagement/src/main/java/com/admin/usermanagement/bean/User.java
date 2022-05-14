package com.admin.usermanagement.bean;
// User Class
public class User {
	
	protected int id;
	protected String name;
	protected String department;
	protected String email;
	protected String mode;
	protected String university;
	protected String cgpa;
	
	public User() {
	}
	
	
	public User(String name, String department,String email, String mode,String university,String cgpa ) {
		super();
		this.name = name;
		this.department = department;
		this.email = email;
		this.mode = mode;
		this.university = university;
		this.cgpa = cgpa;
	}
	
	

	public User(int id,String name, String department,String email, String mode,String university,String cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.mode = mode;
		this.university = university;
		this.cgpa = cgpa;
	}

	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getMode() {
		return mode;
	}
	
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	public String getUniversity() {
		return university;
	}
	
	
	public void setUniversity(String university) {
		this.university = university;
	}
	
	
	public String getCgpa() {
		return cgpa;
	}
	
	
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	
	

}

