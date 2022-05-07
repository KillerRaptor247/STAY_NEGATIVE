package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import classes.*;

public class PetClinic {

	public CustomerDAO customerDAO = new CustomerDAO();
	public PetDAO petDAO = new PetDAO();
	public EmployeeDAO employeeDAO = new EmployeeDAO();
	public Employee signedInEmployee;
	public Customer signedInCustomer;

	public Set<Reciept> reciepts;

	public PetClinic() {
		// create reciepts
		reciepts = new HashSet<Reciept>();
		// load in databases
	}

	public boolean cusLogin(String user, String pass) {
		for (Customer cus : customerDAO.customers.values()) {
			if (cus.getUsername().equals(user) && cus.getPassword().equals(pass)) {
				signedInCustomer = cus;
				return true;
			}
		}
		return false;

	}

	public boolean empLogin(String user, String pass) {

		for (Employee emp : employeeDAO.employees.values()) {
			if (emp.getUsername().equals(user) && emp.getPassword().equals(pass)) {
				signedInEmployee = emp;
				return true;
			}
		}
		return false;
	}

	public boolean noEmployees() {
		return employeeDAO.employees.size() > 0;
	}

	public void importData() {
		// read in and populate all DAOs
		petDAO.importDAO();
		employeeDAO.importDAO();
		customerDAO.importDAO();
	}

	public void exportData() {
		// write out all DAOs
		petDAO.export();
		employeeDAO.export();
		customerDAO.export();
	}

	public boolean isEmployeeEmpty() {
		// return status of employee DAO
		return employeeDAO.employees.size() == 0;
	}

	public boolean find(Pet p) {
		// return status of pet.
		// might need to pass pet parameter
		return false;
	}

	public boolean find(Customer c) {
		// return status of customer
		// might need to pass customer parameter
		return false;
	}

	public boolean find(Employee c) {
		// return status of Employee
		// might need to pass customer parameter
		return false;
	}

	public void adopt(Pet p) {
		// create a reciept and add it to the reciepts

	}

	public Pet getPetInfo(int petID) {
		// search through pet database

		// might not need this
		return new Pet();
	}

	public void addReciept(Reciept newReciept) {
		// TODO Auto-generated method stub
		reciepts.add(newReciept);

	}

}
