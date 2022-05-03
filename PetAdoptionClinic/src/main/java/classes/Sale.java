package classes;

import java.util.Calendar;

public class Sale {
	Customer signedInCustomer;
	Calendar dateAdopted;
	Employee signedInEmployee;
	
	
	public Calendar getDateAdopted() {
		return dateAdopted;
	}
	
	public void setDateAdopted(Calendar dateAdopted) {
		this.dateAdopted = dateAdopted;
	}
	
	public void setEmployee(Employee emp) {
		signedInEmployee = emp;
	}
	
	public void setCustomer(Customer cus) {
		signedInCustomer = cus;

	}
	
	public Employee getEmployee() {
		return signedInEmployee;
	}
	
	public Customer getCustomer() {
		return signedInCustomer;
	}
	
}
