package com.infy;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
@Path("project-services")
public class ProjectService {
	static  ArrayList<Project> projectList=new ArrayList<Project>();
	static{
		Project p1=new Project("101","Live ops",6);
		Project p2=new Project("102","Genesys",12);
		Project p3=new Project("103","Kaiser",18);
		projectList.add(p1);
		projectList.add(p2);
		projectList.add(p3);
	}
	
	@Path("projects")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<Project>  retrieveProjects(){
		return projectList;
	}
		
	@POST
	@Path("insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addProject(@FormParam("projectId") String pId,@FormParam("projectName") String pName,@FormParam("duration")  int time){
		Project project=new Project(pId, pName, time);
		projectList.add(project);
		System.out.println("Total Number of project"+projectList.size());
		System.out.println("resource added successfully");
			}
	
	}
