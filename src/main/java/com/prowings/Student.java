package com.prowings;

public class Student {
	
	private int id;
	private String name;
	private String address;
	private int marks;

	public Student() {
		super();
	}

	public Student(String name, String address, int marks) {
		super();
		this.name = name;
		this.address = address;
		this.marks = marks;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", marks=" + marks + "]";
	}

	
}
