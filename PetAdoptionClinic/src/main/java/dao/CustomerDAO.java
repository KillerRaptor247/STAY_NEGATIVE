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

public class CustomerDAO {
	// declare collection of customers as map of maps to look up password that correlates to
	// appropriate usernames
	protected Map<Integer, Customer> customers;
	
	CustomerDAO(){
		customers = new HashMap<Integer, Customer>();
	}
	
	public void addCustomer(String name, String address, String age, String username, String password, String email) {
		// create a new customer
		Customer newCus = new Customer(name, address, age, username, password, email);
		// add customer to map
		customers.put(newCus.getID(), newCus);
		
	}
	
	public void removeCustomer(Customer customer) {
		
		// if we can find the customer, remove the customer
		if(customers.get(customer.getID()) != null) {
			customers.remove(customer.getID());
		}
		
	}
	
	public void editCustomer(Integer ID, String name, String address, String age, String username, String password, String email) {
		// first get customer from DAO with ID
		Customer updatedCustomer = customers.get(ID);
		// Then update customer member variables
		updatedCustomer.setName(name);
		updatedCustomer.setAddress(address);
		updatedCustomer.setAge(age);
		updatedCustomer.setUsername(username);
		updatedCustomer.setPassword(password);
		updatedCustomer.setEmail(email);
		
		// finally update the DAO with the updated customer
		customers.put(ID, updatedCustomer);
	}
	
	public void export() {
		// create file to append
		
		try {
			FileWriter writer = new FileWriter("CustomerDAO.dat", Boolean.TRUE);
			for(Customer cus : customers.values()) {
				writer.write(cus.getID() + "," + cus.getName() + "," + cus.getAddress() + "," + cus.getAge() + ","
						+ cus.getUsername() + cus.getPassword() + cus.getEmail() + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void importDAO() {
		// if the file doesn't already exist create it
		File dao = new File("CustomerDAO.dat");
		try {
			if(!dao.createNewFile()) {
				BufferedReader br = new BufferedReader(new FileReader(dao));
				
				String line;
				while((line = br.readLine()) != null) {
					// tokenize line and create customers, put them in the map
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
