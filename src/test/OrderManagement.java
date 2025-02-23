package test;

import java.util.ArrayList;
public class OrderManagement {
	private ArrayList<Order> orders;
	private StoreManagement storeManagement;
	private int count;  //for arranging the numbers of orderID
	public OrderManagement() {
		orders = new ArrayList<Order>();
		this.count = 1;
	}
	public void createNewOrder(int userID, Store store) {
		//create new order
		Order newOrder = new Order(count, userID);
		orders.add(newOrder);
		count++;
	}
	public ArrayList<Order> getSeries(){
		return orders;
	}
	public Order findItemByID(int id) {
		//search the order by its orderID
		for (Order order : orders) {		
			if (order.getID() == id) {
				return order;	
			}	
		}
		return null;
	}
	public void assignOrder(int orderID, int storeID) {
		//assign the order to the selected store
		Store store = storeManagement.findStore(storeID);
		Order order = this.findItemByID(orderID);
		order.setStore(store);
		store.addOrder(order);
	}
	
}
