package classes;

import java.util.concurrent.atomic.AtomicInteger;

public class Reciept {
	
	Sale sale;
	
	private static final AtomicInteger number = new AtomicInteger(1000);
	
	Integer ID;
	
	// put loaded constructor to pass for sale
	public Reciept(){
		ID = number.incrementAndGet();
	}
	
	public Reciept(Sale s){
		sale = s;
		ID = number.incrementAndGet();
	}
	
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
