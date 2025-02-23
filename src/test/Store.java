package test;

import java.util.ArrayList;

public class Store {
	private int id, totalOrderAmount, totalBuyAmount;
	private double sales;
	private String location;
	private ArrayList<Series> seriesList;
	private ArrayList<Order> orderList;
	private ArrayList<Integer> quantities;
	private ArrayList<Integer> storeProductIDList;
	private SeriesManagement seriesManagement;

	public Store(int id, String location, User employee) {
		this.id = id;
		this.location = location;
		totalBuyAmount = 0;
		totalOrderAmount = 0;
		sales = 0;
	}
	public void addOrder(Order order) {
		//add the order which is assigned to the store
		orderList.add(order);
	}
	public int getID() {
		return id;
	}
	public String getLocation() {
		return location;
	}
	public double getSales() {
		return sales;
	}
}
