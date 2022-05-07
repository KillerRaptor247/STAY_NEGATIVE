package classes;

import java.util.Calendar;

public class Sale {
	
	public Sale(Pet p, Customer c, Employee e, String d) {
		adoptedPet = p;
		signedInCustomer = c;
		signedInEmployee = e;
		dateAdopted = d;
	}
	
	Pet adoptedPet;
	Customer signedInCustomer;
	String dateAdopted;
	Employee signedInEmployee;
	
	
	public String getDateAdopted() {
		return dateAdopted;
	}
	
	public void setDateAdopted(String dateAdopted) {
		this.dateAdopted = dateAdopted;
	}
	
	public void setEmployee(Employee emp) {
		signedInEmployee = emp;
	}
	
	public void setCustomer(Customer cus) {
		signedInCustomer = cus;

	}
	
	public Integer getPetID() {
		return adoptedPet.getID();
	}
	
	public String getPetName() {
		return adoptedPet.getName();
	}
	
	public Employee getEmployee() {
		return signedInEmployee;
	}
	
	public Customer getCustomer() {
		return signedInCustomer;
	}
	
}
