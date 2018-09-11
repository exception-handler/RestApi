package com.infy.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	int employeeId;
	String name;
	int salary;
	String designation;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", designation="
				+ designation + "]";
	}
	public Employee(int employeeId, String name, int salary, String designation) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
