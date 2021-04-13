package RestaurantApplication;

import java.util.ArrayList;

public class MenuProduct extends Product {
	
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public MenuProduct(String Name, ArrayList<Product> products) {
		super(Name);
		this.products=products;
	}
	
	public double calculateSellingPrice() {
		double SellingPrice = 0;
		for (Product product : products) {
			if (product instanceof MainDish) {
				SellingPrice += product.getSellingPrice()*0.90;
			}
			else if (product instanceof Dessert) {
				SellingPrice += product.getSellingPrice()*0.80;
			}
			else
				SellingPrice += product.getSellingPrice()*0.50;
		}
		return SellingPrice;
	}
	
	public double calculateExpense() {
		double calculateExpense = 0;
		for (Product product : products) {
			calculateExpense = calculateExpense + product.calculateExpense();
		}
		return calculateExpense;
	}
}
