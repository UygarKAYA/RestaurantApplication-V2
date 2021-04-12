package gui.restauranttab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import RestaurantApplication.Restaurant;
import gui.restauranttab.RestaurantPanel;

public class RestaurantListener implements ActionListener {
	
	private Restaurant restaurant;
	private RestaurantPanel RestaurantPanel;

	public RestaurantListener(Restaurant restaurant, RestaurantPanel RestaurantPanel) {
		this.restaurant = restaurant;
		this.RestaurantPanel = RestaurantPanel;
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JButton) {
			JButton button = (JButton) event.getSource();
			if (button.getText().equals("Add Cook")) {
				RestaurantPanel.getCenterPanel().removeAll();
				RestaurantPanel.repaint();
				RestaurantPanel.revalidate();
				RestaurantPanel.AddCook(restaurant);
			}
			
			else if (button.getText().equals("Add Waiter")) {
				RestaurantPanel.getCenterPanel().removeAll();
				RestaurantPanel.repaint();
				RestaurantPanel.revalidate();
				RestaurantPanel.AddWaiter(restaurant);
			}
			
			else if (button.getText().equals("List Emplooyes")) {
				RestaurantPanel.getCenterPanel().removeAll();
				RestaurantPanel.repaint();
				RestaurantPanel.revalidate();
				RestaurantPanel.ListEmplooyes(restaurant);
			}
			
			else if (button.getText().equals("Calculate Expenses")) {
				RestaurantPanel.getCenterPanel().removeAll();
				RestaurantPanel.repaint();
				RestaurantPanel.revalidate();
				RestaurantPanel.CalculateExpense(restaurant);
			}
		}
	}
}