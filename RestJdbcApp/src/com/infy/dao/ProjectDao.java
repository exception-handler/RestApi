package com.infy.dao;
import java.util.List;

import com.infy.model.Project;
public interface ProjectDao {
	List<Project> getAllProjects()throws Exception;
	void addProject(Project proj)throws Exception;
	}
