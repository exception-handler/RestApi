package com.infy.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.infy.dao.ProjectDao;
import com.infy.dao.ProjectDaoImpl;
import com.infy.model.Project;
@Path("projservice")
public class ProjectService {
ProjectDaoImpl p=new ProjectDaoImpl();
@Path("getproj")
@GET
@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
	return p.getAllProjects();
	}
}
