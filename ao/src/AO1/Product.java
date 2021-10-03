package AO1;

public abstract class Product {
	
	public  Product(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
		this.reference = id++;
		
	}
	private static int id = 0;
	private String name;
	private int quantity;
	private int reference;


	

	public String getName() {
		return name;
	}
	
	public abstract boolean canBeSell();

	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", reference=" + reference + "]";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




	
	
	
}