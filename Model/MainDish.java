package RestaurantApplication;

public class MainDish extends Product{

	public MainDish(String Name, double SellingPrice, double PurchasePrice, double UtilityCost) {
		super(Name, SellingPrice, PurchasePrice, UtilityCost);
	}
	
	public double calculateExpense() {
		return super.getPurchasePrice()+super.getUtilityCost();
	}
}
