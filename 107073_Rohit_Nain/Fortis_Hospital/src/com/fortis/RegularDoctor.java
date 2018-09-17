package com.fortis;

import javax.persistence.Entity;

@Entity
public class RegularDoctor extends Doctor{

	private int noOfLeaves;
	private int salary;
	public int getNoOfLeaves() {
		return noOfLeaves;
	}
	public void setNoOfLeaves(int noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "RegularDoctor [noOfLeaves=" + noOfLeaves + ", salary=" + salary + "]";
	}
	public RegularDoctor(String name, String specialization, int noOfLeaves, int salary) {
		super(name, specialization);
		this.noOfLeaves = noOfLeaves;
		this.salary = salary;
	}
	public RegularDoctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegularDoctor(String name, String specialization) {
		super(name, specialization);
		// TODO Auto-generated constructor stub
	}
	
	
}
