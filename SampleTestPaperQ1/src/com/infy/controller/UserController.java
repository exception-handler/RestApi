package com.infy.controller;

import java.sql.SQLException;
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

import com.infy.dao.ManageUser;
import com.infy.dao.ManageUserImpl;

import com.infy.model.User;


@Path("userservice")
public class UserController {

	ManageUserImpl manageUser=new ManageUserImpl();
	
	@Path("show")
	@GET
	@Produces({MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON})
	public List<User> getAllUsers() throws Exception
	{
		return manageUser.getAllUsers();
	}
	
	
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void addUser(User user) throws Exception {
	manageUser.addUser(user);	
	
	}
	
	
	@Path("getJsonById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserById(@PathParam("id")int Id) throws Exception
	{
		return manageUser.getUserById(Id);
	}
	
/*	@Path("getage/{x}/{y}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getSalary(@PathParam("x")int x1,@PathParam("y")int x2) throws SQLException
	{
		
		return manageUser.getBetweenAge(x1,x2);
	}*/
	
	@Path("/query")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getSalary(@QueryParam("x1")int x1,@QueryParam("x2")int x2) throws SQLException
	{
		
		return manageUser.getBetweenAge(x1,x2);
	}
	
	@Path("update")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String updateUser(User user) throws Exception
	{
		manageUser.updateUser(user);
		return "Record Updated";
	}


	@Path("updateName")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String updateUserName(User user) throws Exception
	{
		manageUser.updateUserName(user);
		return "Record Updated";
	}
	
	@Path("remove/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@PathParam("id")String pId) throws Exception
	{
		manageUser.deleteUser(pId);
		return "Record deleted";
	}
	
}
