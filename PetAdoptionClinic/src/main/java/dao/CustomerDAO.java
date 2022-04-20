package dao;

import java.util.HashSet;
import java.util.Set;

import classes.Customer;

public class CustomerDAO {
	private Set<Customer> customers;
	
	CustomerDAO(){
		customers = new HashSet<Customer>();
	}
	
	public int getSize() {
		return customers.size();
	}
	
	public void addCustomer() {
		
	}
	
	public void removeCustomer() {
		
	}
	
	public void editCustomer() {
		
	}
}
