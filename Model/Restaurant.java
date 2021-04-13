package RestaurantApplication;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {

	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private int employeesID = 0;
	
	public Restaurant() {
		initEmployees();
		initProducts();
	}
	
	private void initEmployees() {
		
		addCook("Monica", 100);
		
		addWaiter("Ross");
		addWaiter("Phobe");
		addWaiter("Rachel");
	}
	
	private void initProducts() {
		
		// Parameters for Product Constructor:
		// Product Name, Selling Price, Purchase Price and Utility Cost
		
		products.add(new MainDish("Pizza", 6, 2, 2));
		products.add(new MainDish("Burger", 5, 1.5, 2));
		
		products.add(new Beverage("Coke", 2, 0.5, 0));
		products.add(new Beverage("Lemonade", 2, 0.3, 0));
		
		products.add(new Dessert("Tiramusu", 4, 1, 1));
		products.add(new Dessert("Cake", 3, 0.5, 1));
		products.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		
		ArrayList<Product> HGproducts = new ArrayList<>();
		HGproducts.add(new MainDish("Pizza", 6, 2, 2));
		HGproducts.add(new Beverage("Coke", 2, 0.5, 0));
		HGproducts.add(new Dessert("Tiramusu", 4, 1, 1));
		products.add(new MenuProduct("Hunger Games Menu", HGproducts));
		
		ArrayList<Product> Kidsproducts = new ArrayList<>();
		Kidsproducts.add(new MainDish("Burger", 5, 1.5, 2));
		Kidsproducts.add(new Beverage("Lemonade", 2, 0.3, 0));
		Kidsproducts.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		products.add(new MenuProduct("Kids Menu", Kidsproducts));
	}
	
	public void listEmployees() {
		for (Employee employee : employees) {
			System.out.println("Employee " + employee.getID() + ": " + employee.getName());
		}
	}
	
	public void addCook(String Name ,double Salary) {
		employeesID++;
		Cook cook = new Cook(employeesID,Name,Salary);
		employees.add(cook);
	}
	
	public void addWaiter(String Name) {
		employeesID++;
		Waiter waiter = new Waiter(employeesID,Name);
		employees.add(waiter);
	}
	
	public Waiter assignWaiter() {
		Random rand = new Random();
		int waiterID = rand.nextInt((employeesID-1))+1;
		for (int i=0; i<employees.size(); i++) {
			int ID = employees.get(i).getID();
			if(waiterID == ID) {
				if (employees.get(i) instanceof Waiter) {
					break;
				} 
				else {
					waiterID = rand.nextInt((employeesID-1))+1;
					i=0;
				}
			}
		}
		Waiter waiter = (Waiter) employees.get(waiterID);
		return waiter;
	}
	
	public double calculateRevenue() {
		double revenue = 0;
		ArrayList <Order> orders = new ArrayList <Order>();
		for (Employee employee : employees) {
			if (employee instanceof Waiter) {
				orders.addAll(((Waiter) employee).getOrdersReceived());
			}
		}
		for (Order order : orders) {
			ArrayList <Product> sellingPrices = order.getOrderedProducts();
			for (Product product : sellingPrices) {
				revenue = revenue+product.getSellingPrice();
				if (product instanceof MenuProduct) {
					revenue = revenue+((MenuProduct) product).calculateSellingPrice();
				}
			}
		}
		return revenue;
	}
	
	public double calculateExpenses() {
		double calculateExpenses = 0;
		for (Employee employee : employees) {
			calculateExpenses = calculateExpenses+employee.calculateExpense();
		}
		ArrayList <Order> orders = new ArrayList <Order>();
		for(Employee employee : employees) {
			if (employee instanceof Waiter) {
				orders.addAll(((Waiter) employee).getOrdersReceived());
			}
		}
		for (Order order : orders) {
			ArrayList <Product> OrderExpense = order.getOrderedProducts();
			for (Product product : OrderExpense) {
				calculateExpenses = calculateExpenses+product.calculateExpense();
			}
		}
		return calculateExpenses;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public ArrayList<Employee> getEmployee() {
		return employees;
	}
	
}