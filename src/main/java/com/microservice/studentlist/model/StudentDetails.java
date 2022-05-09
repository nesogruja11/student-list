package com.microservice.studentlist.model;

import java.util.List;

public class StudentDetails {
	
	private String index;
	private String firstName;
	private String lastName;
	private String adress;
	private String email;
	private String phoneNumber;
	private String yearOfStudy;
	private String departmentOfStudy;
	private List<StudentGrades> grades;
	
	public StudentDetails() {}
	
	public StudentDetails(String index, String firstName, String lastName, String adress, String email,
			String phoneNumber, String yearOfStudy, String departmentOfStudy, List<StudentGrades> grades) {
		super();
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.yearOfStudy = yearOfStudy;
		this.departmentOfStudy = departmentOfStudy;
		this.grades = grades;
	}
	
	public List<StudentGrades> getGrades() {
		return grades;
	}
	public void setGrades(List<StudentGrades> grades) {
		this.grades = grades;
	}

	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(String yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public String getDepartmentOfStudy() {
		return departmentOfStudy;
	}
	public void setDepartmentOfStudy(String departmentOfStudy) {
		this.departmentOfStudy = departmentOfStudy;
	}
	
}
