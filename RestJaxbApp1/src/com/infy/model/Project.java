package com.infy.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name="Project_Info")
//@XmlType(propOrder={"id","name","duration"})
@XmlType(propOrder={"id","name"})
public class Project {
    private String id;	
	public Project(String id, String name, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
	}
	private String name;
	private int duration;
	@XmlElement(name="Pid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement(name="Pname")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//@XmlElement(name="Pduration")
	@XmlTransient
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	

}
