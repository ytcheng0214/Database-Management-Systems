package test;

import java.util.ArrayList;
public class SeriesManagement {
	public static ArrayList<Series> serie = new ArrayList<Series>();
	public SeriesManagement() {
	}
	public void addNewProduct(int id,String name,String color,String series,String price) {
		Series newSeries = new Series(id,name,color,series,price);
		serie.add(newSeries);
	}
	public ArrayList<Series> getSeries(){
		return serie;
	}
}
