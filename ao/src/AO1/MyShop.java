

package AO1;

import java.util.*;

public class MyShop {
	private final  Set<Stock> stocks = new HashSet<>();
	
	
	public boolean createStock(String name, String location) {
		return stocks.add(new Stock(name,location));
	}
	

	
	public boolean shopEmpty() {
		return stocks.isEmpty();
	}
	
	private Stock getStock(String nameStock) {
		return stocks.stream().filter(s -> s.getName().equals(nameStock)).findAny().get();
	}

	public boolean addProduct(String nameStock, String nameProduct, int quantity) {
		return getStock(nameStock).addProduct(nameProduct, quantity);
	}

	public boolean noProductInStock(String nameStock) {
		return getStock(nameStock).noProduct();
	}

	public void printProduct(String nameStock, String product) {
		getStock(nameStock).printProduct(product);
		
	}



	public void modifyProduct(String nameStock, String product, int q) {
		getStock(nameStock).modifyProduct(product, q);
		
	}

	
	
	
	
	
}



