package com.infy.controller;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.infy.dao.ProjectServiceImpl;
import com.infy.model.Project;
@Path("projservice")
public class ProjectController {
	ProjectServiceImpl p=new ProjectServiceImpl();
	@Path("greet")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String greet()
	{
		return "Welcome to Project Management Api";
	}
	@Path("getXml")
	@GET
	@Produces({MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON})
	public List<Project> getXml()
	{
		return p.getXml();
	}
	@Path("getJson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getJson()
	{
		return p.getJson();
	}
	
	@Path("update")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String updateProject(Project proj)
	{
		p.updateProject(proj);
		return "Record Updated";
	}
	@Path("remove/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProject(@PathParam("id") String pId)
	{
		p.deletProject(pId);
		return "Record Deleted";
	}
	
	@Path("add")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String addProject(Project proj)
	{
		p.addProject(proj);
		return "Record Added";
	}
}

