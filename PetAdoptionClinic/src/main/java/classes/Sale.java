package classes;

import java.util.Calendar;

public class Sale {
	Double amount;
	Calendar dateAdopted;
	Double tax;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Calendar getDateAdopted() {
		return dateAdopted;
	}
	public void setDateAdopted(Calendar dateAdopted) {
		this.dateAdopted = dateAdopted;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
}
