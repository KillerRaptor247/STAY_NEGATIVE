package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import classes.Customer;
import classes.Employee;

public class EmployeeDAO {
	// map employee id to employee
	public Map<Integer, Employee> employees;
	

	public EmployeeDAO(){
		employees = new HashMap<Integer,Employee>();
	}
	
	public void addEmployee(String name, String address, String age, String username, String password, String email,
			boolean isManager) {
		// create new employee
		Employee newEmp = new Employee(name, address, age, username, password, email, isManager);
		// add employee to table
		employees.put(newEmp.getID(), newEmp);
	}
	
	public void removeEmployee(Integer ID) {
		
		// if we can find the employee, remove the employee
		if(employees.get(ID) != null) {
			employees.remove(ID);
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
			FileWriter writer = new FileWriter("EmployeeDAO.dat", Boolean.FALSE);
			for(Employee emp : employees.values()) {
				writer.write(emp.getID() + "," + emp.getName() + "," + emp.getAddress() + "," + emp.getAge() + ","
						+ emp.getUsername() + "," + emp.getPassword() + "," + emp.getEmail() + "," + emp.isManager() + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void importDAO() {
		// first clear the DAO
		employees.clear();
		// reset the ID count
		Employee.empCount.set(0);
		// if the file doesn't already exist create it
		File dao = new File("EmployeeDAO.dat");
		try {
			if(!dao.createNewFile()) {
				BufferedReader br = new BufferedReader(new FileReader(dao));
				
				String line;
				while((line = br.readLine()) != null) {
					// tokenize line and create customers, put them in the map
					if(line != null) {
						String [] words = line.split(",");
						Employee newEmp = new Employee(words[1], words[2], words[3], words[4], words[5] ,words[6], Boolean.parseBoolean(words[7]));
						newEmp.setID(Integer.parseInt(words[0]));
						employees.put(newEmp.getID(), newEmp);
					}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
