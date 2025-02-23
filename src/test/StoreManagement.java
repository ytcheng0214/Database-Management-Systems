package test;

import java.util.ArrayList;

public class StoreManagement {
	private ArrayList<Store> stores;

	public Store findStore(int storeID) {
		//find the store by its storeID
		for(Store store : stores) {
			if(store.getID() == storeID) {
				return store;
			}
		}
		return null;
	}

}
