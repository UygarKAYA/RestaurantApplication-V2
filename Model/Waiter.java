package RestaurantApplication;

import java.util.ArrayList;

public class Waiter extends Employee {
	
	private double orderRate = 0.10;
	private ArrayList<Order> OrdersReceived; 
	
	public Waiter(int ID, String Name) {
		super(ID,Name);
		OrdersReceived = new ArrayList<Order>();
	}
	
	public void createOrder (Order order) {
		OrdersReceived.add(order);
	}
	
	public ArrayList<Order> getOrdersReceived() {
		return OrdersReceived;
	}
	
	public double calculateExpense() {
		double calculateExpense = 0;
		for (Order order : OrdersReceived) {
			double price = order.calculateTotalPrice()*orderRate;
			calculateExpense +=  price;
		}
		return calculateExpense;
	}
}
