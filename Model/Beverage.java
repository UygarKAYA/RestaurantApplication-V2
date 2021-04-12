package RestaurantApplication;

public class Beverage extends Product {
	
	public Beverage(String Name, double SellingPrice, double PurchasePrice, double UtilityCost) {
		super(Name, SellingPrice, PurchasePrice, UtilityCost);
	}

	public double calculateExpense() {
		return super.getPurchasePrice();
	}
}
