package dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import classes.Customer;
import classes.Employee;

public class EmployeeDAO {
	protected Map<Integer, Employee> employees;
	

	EmployeeDAO(){
		employees = new HashMap<Integer,Employee>();
	}
	
	public void addEmployee(String name, String address, String age, String username, String password, String email,
			boolean isManager) {
		// create new employee
		Employee newEmp = new Employee(name, address, age, username, password, email, isManager);
		// add employee to table
		employees.put(newEmp.getID(), newEmp);
	}
	
	public void removeEmployee(Employee employee) {
		
		// if we can find the employee, remove the employee
		if(employees.get(employee.getID()) != null) {
			employees.remove(employee.getID());
		}
		
	}
	
	public void editEmployee(Integer ID, String name, String address, String age, String username, String password, String email,
			boolean isManager) {
		// first grab employee from DAO with employee Id
		Employee updatedEmployee = employees.get(ID);
		// Then update customer member variables
		updatedEmployee.setName(name);
		updatedEmployee.setAddress(address);
		updatedEmployee.setAge(age);
		updatedEmployee.setUsername(username);
		updatedEmployee.setPassword(password);
		updatedEmployee.setEmail(email);
		updatedEmployee.setManager(isManager);
		
		// finally update the DAO with the updated employee
		employees.put(ID, updatedEmployee);
		
	}
	
	public void export() {
		// create file to append
		try {
			FileWriter writer = new FileWriter("EmployeeDAO.dat", Boolean.TRUE);
			for(Employee emp : employees.values()) {
				writer.write(emp.getID() + "," + emp.getName() + "," + emp.getAddress() + "," + emp.getAge() + ","
						+ emp.getUsername() + emp.getPassword() + emp.getEmail() + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
