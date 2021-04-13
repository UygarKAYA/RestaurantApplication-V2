package RestaurantApplication;

public class Dessert extends Product {

	public Dessert(String Name, double SellingPrice, double PurchasePrice, double UtilityCost) {
		super(Name, SellingPrice, PurchasePrice, UtilityCost);
	}
	
	public double calculateExpense() {
		return super.getPurchasePrice()+super.getUtilityCost();
	}
	
}
