package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import com.infy.model.Employee;


public class EmployeeDaoImpl implements EmployeeDao {

	static List<Employee> plist=new ArrayList<Employee>();
	List<Employee> plist1=new ArrayList<Employee>();
	static{
	
		plist.add(new Employee(101, "Rohit", 100000 , "Senior Manager"));
		plist.add(new Employee(102, "Vipin", 20000 , "junior Manager"));
		plist.add(new Employee(103, "Kala", 20000 , "HR"));
		
     		}
	@Override
	public List<Employee> getXml() {
		// TODO Auto-generated method stub
		return plist;
	}

	@Override
	public List<Employee> getJson() {
		// TODO Auto-generated method stub
		return plist;
	}

	@Override
	public List<Employee> getSalary(int x , int y) {
		for (int i = 0; i < plist.size(); i++) {
			if(plist.get(i).getSalary()>x && plist.get(i).getSalary()<y)
			{
				plist1.add(plist.get(i));
			}
		}
		return plist1;
		
	}

	@Override
	public List<Employee> getEmployeeById(int Id) {
		for (int i = 0; i < plist.size(); i++) {
			if(plist.get(i).getEmployeeId()==Id)
			{
				plist1.add(plist.get(i));
			}
		}
		return plist1;
	}

	@Override
	public void updateEmployeeName(Employee emp) {
		int id=emp.getEmployeeId();
		for (int i = 0; i < plist.size(); i++) {
			if(plist.get(i).getEmployeeId()==id)
			{
				plist.get(i).setName(emp.getName());;
				
			}//if ends
		}//for ends
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		int id=emp.getEmployeeId();
		System.out.println(id);
		for (int i = 0; i < plist.size(); i++) {
			if(plist.get(i).getEmployeeId()==id)
			{
				plist.get(i).setName(emp.getName());
				plist.get(i).setEmployeeId(emp.getEmployeeId());
				plist.get(i).setDesignation(emp.getDesignation());
				plist.get(i).setSalary(emp.getSalary());
				
			}//if ends
		}//for ends
		
		
	}

	@Override
	public void addEmployee(Employee emp) {
		
		plist.add(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		for (int i = 0; i < plist.size(); i++) {
			if(plist.get(i).getEmployeeId()==id)
			{
				plist.remove(i);
			}//if ends
		}//for ends
		
	}


	

}
