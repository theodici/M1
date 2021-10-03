package AO1;

import java.util.Date;
import java.util.GregorianCalendar;



public class DietaryProduct extends Product {
	
	public DietaryProduct(String name, int quantity ,long expiryDate) {
		super(name, quantity);
		this.expiryDate = expiryDate;
		
	}

	private GregorianCalendar expiryDate;

	@Override
	public boolean canBeSell() {
		long date = new Date();
		if (expiryDate - date.getTime()  )
	}
	
	
	
	
}
