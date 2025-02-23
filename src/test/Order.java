package test;

import java.util.ArrayList;

public class Order {
	private int orderID, userID;
	private Store store;
	private int storeid;
	private ArrayList<Series> seriesList;  //An arraylist for saving products in shopping cart
	public Order(int orderID, int userID) {
		this.orderID = orderID;
		this.userID = userID;
		seriesList = new ArrayList<Series>();
	}
	public void setStoreID(int storeid) {
		this.storeid = storeid;
	}
	public int getUserID() {
		return this.userID;
	}
	public int getID() {
		return orderID;
	}
	public Store getStore() {
		return store;
	}
	public int getStoreID() {
		return this.storeid;
	}
	public ArrayList<Series> getSeriesList(){
		return seriesList;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public boolean addSeries(Series serie) {   
		//add item into shopping cart
		for(Series item : seriesList) {
			if(item == serie) {
				return false; //has already in the cart
			}
		}
		seriesList.add(serie);
		return true; //adds successfully
	}

}
