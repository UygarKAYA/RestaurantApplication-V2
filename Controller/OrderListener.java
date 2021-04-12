package gui.ordertab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import RestaurantApplication.Restaurant;
import RestaurantApplication.Waiter;

public class OrderListener implements ActionListener {

	private Restaurant restaurant;
	private OrderPanel orderPanel;
	private Waiter waiter;

	public OrderListener(Restaurant restaurant, OrderPanel orderPanel) {
		this.restaurant = restaurant;
		this.orderPanel = orderPanel;
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() instanceof JButton) {
			JButton OrderButton = (JButton) event.getSource();
			if (OrderButton.getText().equals("New Order")) {
				orderPanel.removeAll();
				orderPanel.OrderPanel2(restaurant);
				waiter = restaurant.assignWaiter();
				JOptionPane.showMessageDialog(null,
						"Hi, I am " + restaurant.assignWaiter().getName() + "." + "\nWhat would you like to order ?");
			}
		}
	}

	public Waiter getWaiter() {
		return waiter;
	}
}
