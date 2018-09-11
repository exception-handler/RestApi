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

import com.infy.dao.EmployeeDaoImpl;
import com.infy.model.Employee;



@Path("empservice")
public class EmployeeService {
	
	EmployeeDaoImpl emp=new EmployeeDaoImpl();
	
	@Path("getXml")
	@GET
	@Produces({MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON})
	public List<Employee> getXml()
	{
		return emp.getXml();
	}
	
	@Path("getJson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getJson()
	{
		return emp.getJson();
	}
	
	@Path("getJsonById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeById(@PathParam("id")int Id)
	{
		return emp.getEmployeeById(Id);
	}
	
	@Path("getSalary/{x}/{y}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getSalary(@PathParam("x")int x1,@PathParam("y")int x2)
	{
		
		return emp.getSalary(x1,x2);
	}
	
	@Path("update")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String updateEmployee(Employee emp1)
	{
		emp.updateEmployee(emp1);
		return "Record Updated";
	}


	@Path("updateName")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String updateEmployeeName(Employee emp1)
	{
		emp.updateEmployeeName(emp1);
		return "Record Updated";
	}
	
	@Path("remove/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(@PathParam("id")int pId)
	{
		emp.deleteEmployee(pId);
		return "Record deleted";
	}
	
	@POST
	@Path("add")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String addProject(Employee emp1)
	{
		emp.addEmployee(emp1);
		return "Employee added";
	}
}
