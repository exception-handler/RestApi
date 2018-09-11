package com.infy.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Project {

	String id;
	String name;
	int duration;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", duration=" + duration + "]";
	}
	public Project(String id, String name, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
