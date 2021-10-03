package AO1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Stock {
	private Set<Product> productsArray;
	private String name;
	private String location;
	
	public Stock(String name, String location) {
		
		this.name = name;
		this.location = location;
		this.productsArray = new  HashSet<>();
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	
	public boolean  addProduct(Product product) {
			return productsArray.add(product);
	}


	public void modifyProduct(String ProductModify, int quantity) {
		Product p = productsArray.stream().filter( pr -> pr.getName().equals(ProductModify)).findAny().get();
		int newQuantity = p.getQuantity()+quantity ;
		System.out.println(newQuantity);
		if (newQuantity <=0) {
			productsArray.remove(p);
		}else {
			p.setQuantity(newQuantity);
		}
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public boolean noProduct() {
		return productsArray.isEmpty();
	}


	public void printProduct(String product) {
		System.out.println(productsArray.stream().filter( pr -> pr.getName().equals(product)).findAny().get().toString());
		
	}
	



	

}
