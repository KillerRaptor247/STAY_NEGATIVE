package classes;

import java.util.concurrent.atomic.AtomicInteger;

public class Reciept {
	
	// member variables
	Sale sale;
	private static final AtomicInteger number = new AtomicInteger(1000);
	Integer ID;
	
	//defualt constrcutor
	public Reciept(){
		ID = number.incrementAndGet();
	}
	
	//parameterized constructor
	public Reciept(Sale s){
		sale = s;
		ID = number.incrementAndGet();
	}
	
	// essential getters and setters
	public Integer getID() {
		return ID;
	}

	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale s) {
		sale = s;
		
	}
	
}
