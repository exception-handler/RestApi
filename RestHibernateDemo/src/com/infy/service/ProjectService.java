package com.infy.service;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.infy.dao.ProjectDao;
import com.infy.dao.ProjectDaoImpl;
import com.infy.model.Project;
@Path("service")
public class ProjectService {
	private ProjectDao iDao = new ProjectDaoImpl();
	@Path("getAll")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Project> getAllProject() {

		// retrieval logic

		return iDao.getAllProjects();
	}
	@Path("add")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.TEXT_PLAIN)
	public String addProject(Project prj) {

		// addition logic

		iDao.addProject(prj);

		return "Record Added";
	}

		}