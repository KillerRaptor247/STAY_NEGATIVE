package classes;

public class Reciept {
	
	Sale sale;
	
	// put loaded constructor to pass for sale
	Reciept(){
		sale = new Sale();
	}

	public Sale getSale() {
		return sale;
	}
	
}
