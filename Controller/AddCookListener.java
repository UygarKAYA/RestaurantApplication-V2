package gui.restauranttab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import RestaurantApplication.Restaurant;

public class AddCookListener implements ActionListener {
	private Restaurant restaurant;
	private JTextField fieldName;
	private JTextField fieldSalary;
	
	public AddCookListener(Restaurant restaurant, JTextField fieldName, JTextField fieldSalary) {
		this.restaurant = restaurant;
		this.fieldName=fieldName;
		this.fieldSalary=fieldSalary;
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			JButton AddButton = (JButton) e.getSource();
			if (AddButton.getText().equals("Add")) {
				try {
					restaurant.addCook(fieldName.getText(), Double.parseDouble(fieldSalary.getText()));
					JOptionPane.showMessageDialog(null, "Cook added succesfully.");
					
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,"Please enter the Name and Salary information");
				}
			}
		}
	}
}
