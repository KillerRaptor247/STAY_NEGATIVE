package classes;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
	
	//declare member variables
	public static final AtomicInteger custCount = new AtomicInteger(0);
	private Integer custID;
	private String name;
	private String address;
	private String age;
	private String username;
	private String password;
	private String email;
	
	// default constructor
	public Customer() {
		
	}
	
	// parameterized constructor
	public Customer(String name, String address, String age, String username, String password, String email) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.username = username;
		this.password = password;
		this.email = email;
		this.custID = custCount.incrementAndGet();
	}
	
	// essential getters and setters
	public String getName() {
		return name;
	}
	public Integer getID() {
		return custID;
	}
	
	public void setID(int id) {
		this.custID = id;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
