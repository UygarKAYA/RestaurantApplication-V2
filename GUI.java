package RestaurantApplication;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import RestaurantApplication.Restaurant;
import gui.ordertab.OrderPanel;
import gui.restauranttab.RestaurantPanel;

public class GUI {

	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		
		JFrame frame = new JFrame("Project");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 500);
		frame.setMinimumSize(new Dimension(650, 500));
		// frame.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel orderPanel = new OrderPanel(restaurant);
		tabbedPane.add("Order", orderPanel);
		
		JPanel restaurantPanel = new RestaurantPanel(restaurant);
		tabbedPane.add("Restaurant", restaurantPanel);
		
		frame.add(tabbedPane);
		
		frame.pack();
	    	frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
