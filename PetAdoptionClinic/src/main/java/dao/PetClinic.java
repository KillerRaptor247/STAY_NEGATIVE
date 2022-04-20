package dao;

import java.util.HashSet;
import java.util.Set;

import classes.*;

public class PetClinic {
	
	CustomerDAO customerDAO;
	PetDAO petDAO;
	EmployeeDAO employeeDAO;
	Employee signedInEmployee;
	Customer signedInCustomer;
	
	Set<Reciept> reciepts;
	
	PetClinic(){
		// create reciepts
		reciepts = new HashSet<Reciept>();
		// load in databases
	}
	
	public void login(String user, String pass) {
		
	}
	
	public void importData() {
		// read in and populate all DAOs
	}
	
	public void exportData() {
		// write out all DAOs
	}
	
	public boolean isEmployeeEmpty() {
		// return status of employee DAO
		return employeeDAO.getSize() == 0;
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
	
	
}
