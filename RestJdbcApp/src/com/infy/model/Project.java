package com.infy.model;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Project {
	int id;	
	String name;
	int duration;
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(int id, String name, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
public String toString()
{
	return id+" "+name+" "+duration;
}
}
