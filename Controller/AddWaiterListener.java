package gui.restauranttab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import RestaurantApplication.Restaurant;

public class AddWaiterListener implements ActionListener {
	private Restaurant restaurant;
	private JTextField TextField;
	
	public AddWaiterListener(Restaurant restaurant, JTextField TextField) {
		this.restaurant = restaurant;
		this.TextField = TextField;
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			
			if (TextField.getText().isEmpty() && button.getText().equals("Add")) {
				JOptionPane.showMessageDialog(null, "Please enter the Waiter informations");
			}
			
			else if (button.getText().equals("Add")) {
				restaurant.addWaiter(TextField.getText());
				JOptionPane.showMessageDialog(null, "Waiter added succesfully.");				
			}			
		}
	}
}
