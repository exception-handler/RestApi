package com.infy.dao;

import java.sql.SQLException;
import java.util.List;

import com.infy.model.User;



public interface ManageUser {
	List<User> getAllUsers()throws Exception;
	void addUser(User user)throws Exception;
	List<User> getBetweenAge(int x, int y) throws SQLException;
	List<User> getUserById(int Id) throws Exception;
	void updateUserName(User user) throws Exception;
	void updateUser(User user)throws Exception;
	void deleteUser(String id)throws Exception;
}
