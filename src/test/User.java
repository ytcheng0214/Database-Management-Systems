package test;

import java.util.ArrayList;

public class User {
	private String name, email, password, phone;
	private int id, totalOrderAmount, totalBuyAmount;
	
	private Order order;
	public User (int id, String email,String phone,String name,String password,int totalBuyAmount,int totalOrderAmount) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.totalOrderAmount = totalOrderAmount;
		this.totalBuyAmount = totalBuyAmount;
	}
	public User(int id,String name,String password,String email,String phone) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	public void calcTotalOrderAmount() {
		totalOrderAmount += order.getSeriesList().size();
	}
	public void calcTotalBuyAmount(){
		this.totalBuyAmount+=1;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
}