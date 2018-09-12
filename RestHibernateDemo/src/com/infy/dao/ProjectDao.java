package com.infy.dao;
import java.util.List;
import com.infy.model.Project;
public interface ProjectDao {
	List<Project> getAllProjects();
	void addProject(Project proj);
	}
