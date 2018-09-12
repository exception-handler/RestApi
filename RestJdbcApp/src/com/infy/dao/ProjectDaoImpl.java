package com.infy.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.infy.model.Project;
import com.infy.utility.ConnectionProvider;
import java.sql.*;
public class ProjectDaoImpl implements ProjectDao {
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps;
	
	@Override
	public void addProject(Project proj)throws Exception {
		System.out.println("Insert method");
		int id=proj.getId();
		String name=proj.getName();
		int duration=proj.getDuration();
String query = "INSERT into myproject VALUES(?,?,?)";
		con=ConnectionProvider.getConnection();
		ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, duration);
		ps.execute();
		System.out.println("Insrted");
	}

	@Override
	public List<Project> getAllProjects()throws Exception{
		Project p;
		List<Project> projList = new ArrayList<Project>();
		con=ConnectionProvider.getConnection();
		ps=con.prepareStatement("select * from myproject");
		 rs=ps.executeQuery();
		 
		while(rs.next())
		{
			p=new Project();
			System.out.println(rs.getInt(1));
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setDuration(rs.getInt(3));
			System.out.println(p);
			projList.add(p);
		}
			
		return projList;
	}

		
		}


