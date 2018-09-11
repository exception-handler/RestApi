package com.infy.dao;
import java.util.List;
import com.infy.model.Project;
public interface ProjectService {
	public List<Project> getXml();
	public List<Project> getJson();
	void addProject(Project proj);
	void updateProject(Project upproj);
	void deletProject(String id);
	
}
