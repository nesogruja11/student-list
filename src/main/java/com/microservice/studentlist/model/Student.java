package com.microservice.studentlist.model;

public class Student {

	private int id;
	private String index;
	private String firstName;
	private String lastName;
	
	public Student() {}
	
	public Student(int id, String index, String firstName, String lastName) {
		super();
		this.id = id;
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
