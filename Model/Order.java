package RestaurantApplication;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public Order () {
		
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void listOrder() {
		if (products.isEmpty()) 
			System.out.println("You have not ordered anything yet !");
		else {
			for (Product product : products) {
				if (product instanceof MenuProduct) {
					System.out.println(product.getName() + ": " + ((MenuProduct) product).calculateSellingPrice());
				}
				else
					System.out.println(product.getName() + ": " + product.getSellingPrice());
			}
		}
	}
	
	public ArrayList<Product> getOrderedProducts() {
		return products;
	}
	
	public double calculateTotalPrice() {
		double TotalPrice = 0;
		for (Product product : products) {
			if (product instanceof MenuProduct) {
				TotalPrice = TotalPrice+((MenuProduct) product).calculateSellingPrice();
			}
			else
				TotalPrice = TotalPrice+product.getSellingPrice();
		}
		return TotalPrice;
	}
}
