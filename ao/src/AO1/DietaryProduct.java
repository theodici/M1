package AO1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class DietaryProduct extends Product {
	
	public DietaryProduct(String name, int quantity ,GregorianCalendar expiryDate) {
		super(name, quantity);
		this.expiryDate = expiryDate;
		
	}

	private GregorianCalendar expiryDate;

	@Override
	public boolean canBeSell() {
		GregorianCalendar tmp = (GregorianCalendar) expiryDate.clone();
		Date today = new Date();
		tmp.add(Calendar.DATE,-3);
		return tmp.after(today);
	}


	
	
	
	
	
}
