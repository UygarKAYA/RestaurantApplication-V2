package gui.ordertab;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import RestaurantApplication.MenuProduct;
import RestaurantApplication.Order;
import RestaurantApplication.Product;
import RestaurantApplication.Restaurant;
import gui.ordertab.OrderListener;

public class OrderPanel extends JPanel {
	
	private JPanel OrderPanel;
	private JLabel PriceLabel;
	private JComboBox<String> ComboBoxproduct;
	private JSpinner spinner;
	private DefaultTableModel TableModel;
	private JButton FinalizeButton;
	private JTable table;
	private Order order = new Order();
	private OrderListener OrderListener;
	
	public OrderPanel(Restaurant restaurant) {
		OrderListener = new OrderListener(restaurant,this);
		JButton OrderButton = new JButton("New Order");
		OrderButton.addActionListener(OrderListener);
		this.add(OrderButton);
	}
	
	public void OrderPanel2(Restaurant restaurant) {
		
		this.setLayout(new GridLayout(2,1));
		OrderPanel = new JPanel();
		OrderPanel.setLayout(null);
		this.add(OrderPanel);
		
		OrderPanel.setBorder(BorderFactory.createTitledBorder("Add Product"));
		
		JLabel LabelProduct = new JLabel("Product: ");
		LabelProduct.setLocation(10,30);
		LabelProduct.setSize(100,10);
		OrderPanel.add(LabelProduct);
		
		JLabel LabelCount = new JLabel("Count: ");
		LabelCount.setLocation(10,70);
		LabelCount.setSize(100,10);
		OrderPanel.add(LabelCount);
		
		JLabel LabelPrice = new JLabel("Price: ");
		LabelPrice.setLocation(10,110);
		LabelPrice.setSize(100,10);
		OrderPanel.add(LabelPrice);
		
		ComboBoxproduct = new JComboBox<>();
		int i=0;
		while (i<restaurant.getProducts().size()) {
			ComboBoxproduct.addItem(restaurant.getProducts().get(i).getName());
			i++;
		}
		ComboBoxproduct.setLocation(315,25);
		ComboBoxproduct.setSize(300,25);
		ComboBoxproduct.setSelectedItem(null);
		OrderPanel.add(ComboBoxproduct);
		
		spinner = new JSpinner();
		spinner.setLocation(315, 65);
		spinner.setSize(300, 25);
		OrderPanel.add(spinner);
		
		PriceLabel = new JLabel("-");
		PriceLabel.setLocation(585, 110);
		PriceLabel.setSize(50,10);
		OrderPanel.add(PriceLabel);
		
		JButton AddButton = new JButton("Add");
		AddButton.setLocation(315, 140);
		AddButton.setSize(300,25);
		OrderPanel.add(AddButton);
		
		JPanel CurrentOrderPanel = new JPanel();
		CurrentOrderPanel.setLayout(new BorderLayout());
		CurrentOrderPanel.setBorder(BorderFactory.createTitledBorder("Current Order"));
		this.add(CurrentOrderPanel);
		
		String[] columnNames = {"Product Name","Count","Price"};
		
		TableModel = new DefaultTableModel();
		TableModel.setColumnIdentifiers(columnNames);
		
		table = new JTable(TableModel);
		table.setModel(TableModel);
		table.setBackground(Color.WHITE);
		table.setPreferredScrollableViewportSize(getPreferredSize());
		
		CurrentOrderPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel currentOrderDownPanel = new JPanel(new BorderLayout());
		
		FinalizeButton = new JButton("Finalize");
		FinalizeButton.setSize(100,25);
		FinalizeButton.setEnabled(false);
		
		currentOrderDownPanel.add(FinalizeButton, BorderLayout.EAST);
		CurrentOrderPanel.add(currentOrderDownPanel, BorderLayout.SOUTH);
		
		AddOrderListener addOrderListener = new AddOrderListener(restaurant);
		AddButton.addActionListener(addOrderListener);
		ComboBoxproduct.addActionListener(addOrderListener);
		FinalizeButton.addActionListener(addOrderListener);
		
	}
	
	class AddOrderListener implements ActionListener {
		
		private Restaurant restaurant;
		
		public AddOrderListener(Restaurant restaurant) {
			this.restaurant = restaurant;
		}
		
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() instanceof JButton) {
				JButton Button = (JButton) event.getSource();
				if (Button.getText().equals("Add")) {
					
					FinalizeButton.setEnabled(true);
					int SpinnerValueCount = (int)spinner.getValue();
					
					if (SpinnerValueCount>0) {
						
						String selectedItem = String.valueOf(ComboBoxproduct.getSelectedItem());
						int count = (int)spinner.getValue();
						double CalculateSellingPrice = 0;
						
						ArrayList<Product> products = restaurant.getProducts();
						
						for (int i=0; i<products.size(); i++) {
							if (ComboBoxproduct.getSelectedItem().equals(products.get(i).getName())) {
								int j=1;
								if (products.get(i) instanceof MenuProduct) {
									while (j<=count) {
										CalculateSellingPrice = ((MenuProduct) products.get(i)).calculateSellingPrice();
										order.addProduct(products.get(i));
										j++;
									}
								} 
								else {
									while (j<=count) {
										CalculateSellingPrice = products.get(i).getSellingPrice();
										order.addProduct(products.get(i));
										j++;
									}
								}
							}
						}
						CalculateSellingPrice = CalculateSellingPrice*count;
						TableModel.addRow(new Object[] {selectedItem, count, CalculateSellingPrice});
					}
					else if (SpinnerValueCount==0) {
						JOptionPane.showMessageDialog(null, "Please select the number how many you want.");
					}
					else if (SpinnerValueCount<0) {
						JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
					}
				}
				
				else if (Button.getText().equals("Finalize")) {
					OrderListener.getWaiter().getOrdersReceived().add(order);
					double FinalizePrice = 0;
					ArrayList<Object> Arraylist = new ArrayList<Object>();
					for (int i = 0; i < table.getModel().getRowCount(); i++) {
						Arraylist.add(table.getValueAt(i, 2));
					}
					for (int i=0; i<Arraylist.size(); i++) {
						double price = new Double((double)Arraylist.get(i));
						FinalizePrice = FinalizePrice+price;
					}
					JOptionPane.showMessageDialog(null,"Your order is completed.\nTotal price is "+FinalizePrice+" TL");
					order = new Order();
					UpdatePanel(restaurant);
				}
			}
			
			if (event.getSource() instanceof JComboBox) {
				ArrayList<Product> products = restaurant.getProducts();
				JComboBox<String> list = (JComboBox<String>)event.getSource();
				
				for (int i=0; i<products.size(); i++) {
					if (products.get(i).getName().equals(String.valueOf(list.getSelectedItem()))) {
						if (products.get(i) instanceof MenuProduct) 
							PriceLabel.setText(String.valueOf(((MenuProduct) products.get(i)).calculateSellingPrice())+" TL");
						else 
							PriceLabel.setText(products.get(i).toString() + " TL");
					}
				}
			}
		}
	}
	public void UpdatePanel(Restaurant restaurant) {
		UpdatePanel updatePanel = new UpdatePanel(this, restaurant);
	}	
}