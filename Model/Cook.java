package RestaurantApplication;

public class Cook extends Employee {
	
	private double Salary;
	private double TaxRate = 0.18;
	
	public Cook(int ID, String Name, double Salary) {
		super(ID,Name);
		this.Salary=Salary;
	}
	
	public double getSalary() {
		return Salary;
	}
	
	public double getTaxRate() {
		return TaxRate;
	}
	
	public double calculateExpense() {
		return Salary + (Salary*TaxRate);
	}
}
