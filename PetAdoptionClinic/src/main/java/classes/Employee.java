package classes;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee extends Customer{
	
	// member variables
	public static final AtomicInteger empCount = new AtomicInteger(0);
	private Integer empId;
	boolean isManager;

	// parameterized constructor
	public Employee(String name, String address, String age, String username, String password, String email,
			boolean isManager) {
		super(name, address, age, username, password, email);
		this.isManager = isManager;
		empId = empCount.incrementAndGet();
	}

	// default constructor
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	// basic getters and setters
	public Integer getID() {
		return empId;
	}
	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	
}
