package com.infy.dao;

import java.util.List;

import com.infy.model.Employee;


public interface EmployeeDao {
	public List<Employee> getXml();
	public List<Employee> getJson();

	List<Employee> getSalary(int x, int y);
	List<Employee> getEmployeeById(int Id);
	void updateEmployeeName(Employee emp);
	void updateEmployee(Employee emp);
	void addEmployee(Employee emp);
	void deleteEmployee(int id);

}
