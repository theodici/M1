package AO1;

public class HealthProduct extends Product {

	public HealthProduct(String name, int quantity) {
		super(name, quantity);
	}
	
	public boolean canBeSell() {
		return true;
	}

}
