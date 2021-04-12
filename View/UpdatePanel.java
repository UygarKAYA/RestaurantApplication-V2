package gui.ordertab;

import javax.swing.JButton;

import RestaurantApplication.Restaurant;

public class UpdatePanel {
	
	public UpdatePanel(OrderPanel orderPanel, Restaurant restaurant) {
		
		orderPanel.removeAll();
		orderPanel.revalidate();
		orderPanel.repaint();
		
		OrderListener OrderListiner = new OrderListener(restaurant, orderPanel);
		JButton orderButton = new JButton("New Order");
		orderPanel.setLayout(null);
		orderButton.setLocation(260, 10);
		orderButton.setSize(96, 26);
		orderButton.addActionListener(OrderListiner);
		orderPanel.add(orderButton);
	}
}
