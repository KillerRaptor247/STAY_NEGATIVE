package dao;

import java.util.HashSet;
import java.util.Set;

import classes.Employee;

public class EmployeeDAO {
	private Set<Employee> employees;
	

	EmployeeDAO(){
		employees = new HashSet<Employee>();
	}
	
	public int getSize() {
		return employees.size();
	}
	
	public void addEmployee() {
		
	}
	
	public void removeEmployee() {
		
	}
	
	public void editEmployee() {
		
	}
}
