package RestaurantApplication;

public abstract class Employee implements Expense {
	
	private int ID;
	private String Name;
	
	public Employee(int ID, String Name) {
		this.ID=ID;
		this.Name=Name;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}
	
	public String toString() {
		return "ID: " + this.ID + "Name: " + this.Name;
	}
}
