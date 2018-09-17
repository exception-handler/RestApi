package com.fortis;

import javax.persistence.Entity;

@Entity
public class VisitingDoctor extends Doctor{

	private int visitingHours;
	private int visitingCharges;
	public int getVisitingHours() {
		return visitingHours;
	}
	public void setVisitingHours(int visitingHours) {
		this.visitingHours = visitingHours;
	}
	public int getVisitingCharges() {
		return visitingCharges;
	}
	public void setVisitingCharges(int visitingCharges) {
		this.visitingCharges = visitingCharges;
	}
	@Override
	public String toString() {
		return "VisitingDoctor [visitingHours=" + visitingHours + ", visitingCharges=" + visitingCharges + "]";
	}
	public VisitingDoctor(String name, String specialization, int visitingHours, int visitingCharges) {
		super(name, specialization);
		this.visitingHours = visitingHours;
		this.visitingCharges = visitingCharges;
	}
	public VisitingDoctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisitingDoctor(String name, String specialization) {
		super(name, specialization);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
