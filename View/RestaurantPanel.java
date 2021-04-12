package gui.restauranttab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import RestaurantApplication.Cook;
import RestaurantApplication.Restaurant;
import RestaurantApplication.Waiter;

public class RestaurantPanel extends JPanel {
	
	private Restaurant restaurant;
	private JPanel CenterPanel;
	
	public JPanel getCenterPanel() {
		return CenterPanel;
	}
	
	public RestaurantPanel(Restaurant restaurant) {
		
		this.restaurant=restaurant;
		this.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		this.add(buttonPanel, BorderLayout.NORTH);
		
		CenterPanel = new JPanel();
		this.add(CenterPanel, BorderLayout.CENTER);

		RestaurantListener restaurantController = new RestaurantListener(restaurant,this);
		
		JButton ListEmplooyees = new JButton("List Emplooyes");
		buttonPanel.add(ListEmplooyees);
		ListEmplooyees.addActionListener(restaurantController);
		
		JButton AddCook = new JButton("Add Cook");
		buttonPanel.add(AddCook);
		AddCook.addActionListener(restaurantController);
		
		JButton AddWaiter = new JButton("Add Waiter");
		buttonPanel.add(AddWaiter);
		AddWaiter.addActionListener(restaurantController);
		
		JButton CalculateExpenses = new JButton("Calculate Expenses");
		buttonPanel.add(CalculateExpenses);
		CalculateExpenses.addActionListener(restaurantController);
	}
	
	public void AddCook(Restaurant restaurant) {
		
		CenterPanel.setLayout(new GridLayout(10,1));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		CenterPanel.add(panel1);
		
		JLabel NameLabel = new JLabel("Name: ");
		NameLabel.setLocation(10, 0);
		NameLabel.setSize(100,10);
		panel1.add(NameLabel);
		
		JTextField NameField = new JTextField();
		NameField.setLocation(300, 0);
		NameField.setSize(325,25);
		panel1.add(NameField);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		CenterPanel.add(panel2);
		
		JLabel SalaryLabel = new JLabel("Salary: ");
		SalaryLabel.setLocation(10,0);
		SalaryLabel.setSize(100,20);
		panel2.add(SalaryLabel);
		
		JTextField SalaryField = new JTextField();
		SalaryField.setLocation(300, 0);
		SalaryField.setSize(325,25);
		panel2.add(SalaryField);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		CenterPanel.add(panel3);
		
		AddCookListener addCookListener = new AddCookListener(restaurant, NameField, SalaryField);
		
		JButton AddButton = new JButton("Add");
		AddButton.setLocation(300, 0);
		AddButton.setSize(325,25);
		AddButton.addActionListener(addCookListener);
		panel3.add(AddButton);
	}
	
	public void AddWaiter(Restaurant restaurant) {
		
		CenterPanel.setLayout(new GridLayout(10,1));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		CenterPanel.add(panel1);
		
		JLabel NameLabel = new JLabel("Name: ");
		NameLabel.setLocation(10, 0);
		NameLabel.setSize(100,10);
		panel1.add(NameLabel);
		
		JTextField NameField = new JTextField();
		NameField.setLocation(300, 0);
		NameField.setSize(325,25);
		panel1.add(NameField);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		CenterPanel.add(panel2);
		
		AddWaiterListener addWaiterListener = new AddWaiterListener(restaurant, NameField);
		
		JButton AddButton = new JButton("Add");
		AddButton.setLocation(300, 0);
		AddButton.setSize(325,25);
		AddButton.addActionListener(addWaiterListener);
		panel2.add(AddButton);
	}
	
	public void ListEmplooyes(Restaurant restaurant) {
		
		CenterPanel.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 148, 5));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 150, 5));
		
		JLabel IDLabel = new JLabel("ID");
		IDLabel.setForeground(Color.RED);
		panel.add(IDLabel);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setForeground(Color.RED);
		panel.add(NameLabel);
		
		JLabel JobLabel = new JLabel("Job");
		JobLabel.setForeground(Color.RED);
		panel.add(JobLabel);

		for (int i=0; i<restaurant.getEmployee().size(); i++) {
			panel2.add(new JLabel(String.valueOf(restaurant.getEmployee().get(i).getID())));
			panel2.add(new JLabel(restaurant.getEmployee().get(i).getName()));
			
			String jobs = "";
			if (restaurant.getEmployee().get(i) instanceof Waiter) 
				jobs = "Waiter";
			else if (restaurant.getEmployee().get(i) instanceof Cook) 
				jobs = "Cook";
			
			panel2.add(new JLabel(jobs));
			panel.add(panel2, BorderLayout.NORTH);
		}
		
		CenterPanel.add(panel, BorderLayout.NORTH);
		CenterPanel.add(panel2, BorderLayout.CENTER);
	}
	
	public void CalculateExpense(Restaurant restaurant) {
		
		CenterPanel.setLayout(new GridLayout(1,1));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		CenterPanel.add(panel1);
		
		JLabel ExpensesLabel = new JLabel("Expenses: ");
		ExpensesLabel.setLocation(10, 0);
		ExpensesLabel.setSize(100,10);
		panel1.add(ExpensesLabel);
		
		JLabel RevenueLabel = new JLabel("Revenue: ");
		RevenueLabel.setLocation(10, 30);
		RevenueLabel.setSize(100,10);
		panel1.add(RevenueLabel);
		
		JLabel ProfitLabel = new JLabel("Profit: ");
		ProfitLabel.setLocation(10, 60);
		ProfitLabel.setSize(100,10);
		panel1.add(ProfitLabel);
		
		JLabel CalculateExpensesLabel = new JLabel(String.valueOf(restaurant.calculateExpenses()) + " TL");
		CalculateExpensesLabel.setLocation(300, 0);
		CalculateExpensesLabel.setSize(100,10);
		panel1.add(CalculateExpensesLabel);
		
		JLabel CalculateRevenueLabel = new JLabel(String.valueOf(restaurant.calculateRevenue())+ " TL");
		CalculateRevenueLabel.setLocation(300, 30);
		CalculateRevenueLabel.setSize(100,10);
		panel1.add(CalculateRevenueLabel);
		
		JLabel CalculateProfitLabel = new JLabel(String.valueOf(restaurant.calculateRevenue()-restaurant.calculateExpenses())+ " TL");
		CalculateProfitLabel.setLocation(300, 60);
		CalculateProfitLabel.setSize(100,10);
		panel1.add(CalculateProfitLabel);		
	}
}
