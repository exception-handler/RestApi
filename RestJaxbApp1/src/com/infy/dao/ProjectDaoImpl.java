package com.infy.dao;

import java.util.ArrayList;
import java.util.List;
import com.infy.model.Project;
public class ProjectDaoImpl implements ProjectDao {
	static  ArrayList<Project> projectList=new ArrayList<Project>();
	static{
		Project p1=new Project("101","Live ops",6);
		Project p2=new Project("102","Genesys",12);
		Project p3=new Project("103","Kaiser",18);
		projectList.add(p1);
		projectList.add(p2);
		projectList.add(p3);
	}
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
	return projectList;
	}

}
