package test;

import java.util.ArrayList;

public class Series{
	private String name, color, series, price;
	private int id;
	public Series(int id,String name,String color,String series,String price) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.series = series;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}
	public int getID() {
		return this.id;
	}
	public String getColor() {
		return this.color;
	}
	public String getSeries() {
		return this.series;
	}
}
