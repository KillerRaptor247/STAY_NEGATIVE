package classes;

public class Reciept {
	
	Sale sale;
	
	// put loaded constructor to pass for sale
	public Reciept(){
		
	}
	
	public Reciept(Sale s){
		sale = s;
	}

	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale s) {
		sale = s;
		
	}
	
}
