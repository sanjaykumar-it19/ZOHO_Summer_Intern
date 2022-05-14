package com.demorest.restapi;



import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Student {

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + ", email=" + email + ", mode="
				+ mode + ", university=" + university + ", cgpa=" + cgpa + "]";
	}
	private int id;
	private String name;
	private String department;
	private String email;
	private String mode;
	private String  university;
	private String cgpa;
	
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
