package RestaurantApplication;

public abstract class Product implements Expense{
	
	private String Name;
	private double SellingPrice;
	private double PurchasePrice;
	private double UtilityCost;
	
	public Product (String Name, double SellingPrice, double PurchasePrice, double UtilityCost) {
		this.Name=Name;
		this.SellingPrice=SellingPrice;
		this.PurchasePrice=PurchasePrice;
		this.UtilityCost=UtilityCost;		
	}
	
	public Product (String Name) {
		this.Name=Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	public double getPurchasePrice() {
		return PurchasePrice;
	}
	
	public double getSellingPrice() {
		return SellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.SellingPrice = sellingPrice;
	}
	
	public double getUtilityCost() {
		return UtilityCost;
	}
	
	public String toString() {
		return "" + this.getSellingPrice();
	}
}
