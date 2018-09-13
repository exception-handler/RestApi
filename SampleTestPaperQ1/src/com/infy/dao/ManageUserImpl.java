package com.infy.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infy.model.User;
import com.infy.utility.ConnectionProvider;

public class ManageUserImpl implements ManageUser{
	static List<User> userList=new ArrayList<>();
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps;
	
	@Override
	public List<User> getAllUsers() throws Exception {
		User user;
		
		con = ConnectionProvider.getConnection();
		ps=con.prepareStatement("select * from myUser");
		rs=ps.executeQuery();
		while(rs.next())
		{
			userList.add(new User(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			
		}
		return userList;
	}

	@Override
	public void addUser(User user) throws Exception {
		System.out.println("Insert Method");
		String id=user.getId();
		String name=user.getName();
		int age=user.getAge();
		String address=user.getAddress();
		String query="insert into myuser values(?,?,?,?)";
		con=ConnectionProvider.getConnection();
		ps=con.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, address);
		ps.executeUpdate();
		System.out.println("Inserted");
		
	}

	@Override
	public List<User> getBetweenAge(int x, int y) throws SQLException {
		List<User> userlist1= new ArrayList<>();
		String query="select * from myuser where age  between ? and ?";
		con=ConnectionProvider.getConnection();
		ps=con.prepareStatement(query);
		ps.setInt(1, x);
		ps.setInt(2, y);
		rs=ps.executeQuery();
		while(rs.next())
		{
			
			userlist1.add(new User(rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4)));
			
		}
		return userlist1;
	}

	@Override
	public List<User> getUserById(int Id) throws Exception {
		System.out.println("Inside getUserById");
		String query="select * from myuser where id=?";
		con=ConnectionProvider.getConnection();
		ps=con.prepareStatement(query);
		ps.setInt(1, Id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			userList.add(new User(rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		return userList;
	}

	@Override
	public void updateUserName(User user) throws Exception {
	System.out.println("Inside update by name");
	String query="update myuser SET name =? WHERE id =?";
		con=ConnectionProvider.getConnection();
		ps=con.prepareStatement(query);
		ps.setString(1, user.getName());
		ps.setString(2, user.getId());
		System.out.println("afggggggggggsb");
		ps.executeUpdate();
		System.out.println("egfffffffffffffffh");
	}

	@Override
	public void updateUser(User user) throws Exception {
		System.out.println("Inside update user");
		String query="update myuser SET name =?, age=?, address=? WHERE id =?";
		con=ConnectionProvider.getConnection();	
		ps=con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getId());
			ps.executeUpdate();
		
	}

	@Override
	public void deleteUser(String id) throws Exception {
	System.out.println("inside delete");
	String query="delete from myuser WHERE id =?";
	con=ConnectionProvider.getConnection();	
	ps=con.prepareStatement(query);
	ps.setString(1, id);
	ps.executeUpdate();
	}


}
